package com.app.taskflow.services;

import com.app.taskflow.entity.User;
import com.app.taskflow.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://127.0.0.1:3000")
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public User updateUser(Long userId, User updatedUser) {
        // Check if the user exists
        if (!userRepository.existsById(userId)) {
            return null; // Or throw a custom exception
        }
        updatedUser.setId(userId); // Ensure the ID is set for the update
        return userRepository.save(updatedUser); // Save and return the updated user
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmpId(generateEmpId());
        return userRepository.save(user);
    }

    public Optional<User> authenticateUser(String identifier, String password) {
        User user = userRepository.findByEmail(identifier);
        if (user == null) {
            user = userRepository.findByEmpId(identifier);
        }
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            user = userRepository.findByEmpId(username);
        }
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }

    private String generateEmpId() {
        String prefix = "EMP";
        long count = userRepository.count() + 1; // Assuming no deletions
        return prefix + String.format("%04d", count); // Generates EMP0001, EMP0002...
    }
}
