package com.tri.accountservice.configuration;

import com.tri.accountservice.entity.User;
import com.tri.accountservice.enums.Role;
import com.tri.accountservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class AppConfig {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public ApplicationRunner applicationRunner(){
        return args -> {
            createAnUserRoleAdmin();
            createAnUserRoleUser();
        };
    }


    private void createAnUserRoleAdmin(){
        User user = User.builder()
                .email("admin@gmail.com")
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .isActive(true)
                .role(Role.ADMIN)
                .build();
        userRepository.save(user);
    }

    private void createAnUserRoleUser(){
        User user = User.builder()
                .email("user@gmail.com")
                .username("user")
                .password(passwordEncoder.encode("user"))
                .isActive(true)
                .role(Role.USER)
                .build();
        userRepository.save(user);
    }




}
