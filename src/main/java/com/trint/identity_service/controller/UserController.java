package com.trint.identity_service.controller;

import com.trint.identity_service.dto.request.UserCreationRequest;
import com.trint.identity_service.dto.request.UserUpdateRequest;
import com.trint.identity_service.entity.User;
import com.trint.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    User getUserById(@PathVariable("userId") String userId) {
        return userService.getUserByUserId(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@RequestBody UserUpdateRequest request, @PathVariable String userId) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
