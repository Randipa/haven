package com.example.PostApet.Service;

import com.example.PostApet.dto.ActivityEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ActivityService {
    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();
    private final Deque<ActivityEvent> recentEvents = new LinkedList<>();

    public SseEmitter createEmitter() {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        this.emitters.add(emitter);
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        return emitter;
    }

    public void sendActivity(ActivityEvent event) {
        recentEvents.addFirst(event);
        if (recentEvents.size() > 10) {
            recentEvents.removeLast();
        }
        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(SseEmitter.event().name("activity").data(event));
            } catch (IOException e) {
                emitters.remove(emitter);
            }
        }
    }

    public List<ActivityEvent> getRecentEvents(int limit) {
        return recentEvents.stream().limit(limit).toList();
    }
}
