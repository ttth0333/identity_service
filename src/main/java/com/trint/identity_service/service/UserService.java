package com.trint.identity_service.service;

import com.trint.identity_service.dto.request.UserCreationRequest;
import com.trint.identity_service.dto.request.UserUpdateRequest;
import com.trint.identity_service.entity.User;
import com.trint.identity_service.exception.AppException;
import com.trint.identity_service.exception.ErrorCode;
import com.trint.identity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        if(userRepository.existsByUsername(request.getUsername()))
//            throw new RuntimeException("Username already exists");
//            throw new AppException(ErrorCode.USER_EXISTED);
            throw new RuntimeException("ErrorCode.USER_EXISTED");

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUserId(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = getUserByUserId(userId);

        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
