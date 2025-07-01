package com.example.PostApet.Controller;

import com.example.PostApet.Service.jwt.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/admin/metrics")
@CrossOrigin(origins = "http://localhost:3000")
public class UserMetricsController {

    private final UserService userService;

    @Autowired
    public UserMetricsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<Map<String, Long>> getUserMetrics() {
        return ResponseEntity.ok(userService.getUserRoleCounts());
    }
}
