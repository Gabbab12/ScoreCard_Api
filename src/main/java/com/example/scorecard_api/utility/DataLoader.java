package com.example.scorecard_api.utility;

import com.example.scorecard_api.enums.Gender;
import com.example.scorecard_api.enums.Role;
import com.example.scorecard_api.model.SuperAdmin;
import com.example.scorecard_api.model.User;
import com.example.scorecard_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataLoader {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${admin.password:password}")
    private String adminPassword;
    @Value("${super.email:email}")
    private String adminEmail;

    @Bean
    public CommandLineRunner preloadAdmin() {
        User user = userRepository.findFirstByRole(Role.SUPER_ADMIN).orElse(null);
        if (user == null) {
            return args -> {
                SuperAdmin user1 = new SuperAdmin("Chika", "Nwobi", Gender.MALE, adminEmail, Role.SUPER_ADMIN, passwordEncoder.encode(adminPassword),true);
                userRepository.save(user1);
            };
        }
        return null;
    }
}