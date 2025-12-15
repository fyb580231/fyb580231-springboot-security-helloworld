package com.example.helloworld.service;

import com.example.helloworld.dto.RegisterRequest;
import com.example.helloworld.model.User;
import com.example.helloworld.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService { // 不再实现 UserDetailsService

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 初始化测试用户
     */
    @PostConstruct
    public void initTestUser() {
        Optional<User> testUser = userRepository.findByUsername("test");
        if (!testUser.isPresent()) {
            User user = new User();
            user.setUsername("test");
            user.setPassword(passwordEncoder.encode("123456"));
            userRepository.save(user);
        }
    }

    /**
     * 注册用户
     */
    public User register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
    }
}