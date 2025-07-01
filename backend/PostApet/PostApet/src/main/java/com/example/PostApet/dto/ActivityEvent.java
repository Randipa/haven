package com.example.PostApet.dto;

import java.time.LocalDateTime;

public class ActivityEvent {
    private Long id;
    private String type;
    private String message;
    private LocalDateTime time;

    public ActivityEvent() {}

    public ActivityEvent(Long id, String type, String message, LocalDateTime time) {
        this.id = id;
        this.type = type;
        this.message = message;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
