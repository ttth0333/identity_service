package com.trint.identity_service.service;

import com.trint.identity_service.dto.request.UserCreationRequest;
import com.trint.identity_service.dto.request.UserUpdateRequest;
import com.trint.identity_service.dto.response.UserResponse;
import com.trint.identity_service.entity.User;
import com.trint.identity_service.exception.AppException;
import com.trint.identity_service.exception.ErrorCode;
import com.trint.identity_service.mapper.UserMapper;
import com.trint.identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

//    @Autowired
//    private final UserRepository userRepository;
//    @Autowired
//    private final UserMapper userMapper;

    public User createUser(UserCreationRequest request) {


        if(userRepository.existsByUsername(request.getUsername()))
//            throw new RuntimeException("Username already exists");
//            throw new AppException(ErrorCode.USER_EXISTED);
            throw new RuntimeException("ErrorCode.USER_EXISTED");
//        User user = new User();
//        user.setUsername(request.getUsername());
//        user.setPassword(request.getPassword());
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setDob(request.getDob());
        User user = userMapper.toUser(request);

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserResponse getUserByUserId(String id) {
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
//        user.setPassword(request.getPassword());
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setDob(request.getDob());
        userMapper.updateUser(user, request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
