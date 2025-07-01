package com.example.PostApet.Repository;



import com.example.PostApet.Enum.UserRole;
import com.example.PostApet.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findFirstByEmail(String email);

    List<User> findAllByUserRole(UserRole userRole);
}
