package com.example.PostApet.Service;

import com.example.PostApet.Enum.UserRole;
import com.example.PostApet.Repository.UserRepository;
import com.example.PostApet.dto.UserStatsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStatsService {
    private final UserRepository userRepository;

    @Autowired
    public UserStatsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserStatsDto getUserStats() {
        UserStatsDto dto = new UserStatsDto();
        dto.setTotalUsers(userRepository.count());
        dto.setAdminCount(userRepository.countByUserRole(UserRole.ADMIN));
        dto.setUserCount(userRepository.countByUserRole(UserRole.USER));
        return dto;
    }
}
