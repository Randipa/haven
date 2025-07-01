package com.example.PostApet.Controller;

import com.example.PostApet.Service.UserStatsService;
import com.example.PostApet.dto.UserStatsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/stats")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminStatsController {
    private final UserStatsService userStatsService;

    @Autowired
    public AdminStatsController(UserStatsService userStatsService) {
        this.userStatsService = userStatsService;
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserStatsDto> getUserStats() {
        return ResponseEntity.ok(userStatsService.getUserStats());
    }
}
