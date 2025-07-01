package com.example.PostApet.Controller;

import com.example.PostApet.Service.ActivityService;
import com.example.PostApet.dto.ActivityEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activity")
@CrossOrigin(origins = "http://localhost:3000")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/stream")
    public SseEmitter streamActivity() {
        return activityService.createEmitter();
    }

    @GetMapping("/recent")
    public List<ActivityEvent> recentActivity() {
        return activityService.getRecentEvents(5);
    }
}
