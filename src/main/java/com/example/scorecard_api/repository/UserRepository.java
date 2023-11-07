package com.example.scorecard_api.repository;


import com.example.scorecard_api.enums.Role;
import com.example.scorecard_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
     Optional<User> findByEmail(String email);
     Optional<User> findFirstByRole(Role role);
     Optional<User> findById(Long id);
     Optional<User> findUserByIdAndRole(Long id, Role role);


}
