package com.app.taskflow.controller;


import com.app.taskflow.entity.Task;
import com.app.taskflow.entity.User;
import com.app.taskflow.repository.UserRepository;
import com.app.taskflow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins="http://0.0.0.0:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

//    @Autowired
//    private UserRepository userRepository;
//    @GetMapping("/all")

    @Autowired
    private UserService userService;
// EDITED AT 15:59 (3.59PM 25-09-2024))
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return ResponseEntity.ok("User deleted successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }
        return ResponseEntity.ok("User updated successfully");
    }
// edited block end


    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        User createdUser = userService.registerUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String identifier, @RequestParam String password) {
        var user = userService.authenticateUser(identifier, password);
        if (user.isPresent()) {
            User user1 = user.get();
            return ResponseEntity.ok(user1);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}
