package com.example.canteenservice.services.impl;

import com.example.canteenservice.dto.UserDTO;
import com.example.canteenservice.grpc.clients.UserClient;
import com.example.canteenservice.services.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserClient userClient;

    public UserServiceImpl(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        userDTO.setPassword(hashPassword(userDTO.getPassword()));
        return userClient.createUser(userDTO);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return userClient.getUserByUsername(username);
    }

    @Override
    public UserDTO authenticateUser(UserDTO userDTO) {
        UserDTO userByUsername = getUserByUsername(userDTO.getUsername());
        if (userByUsername == null) {
            throw new RuntimeException("User not found");
        }
        if (!checkPassword(userDTO.getPassword(), userByUsername.getPassword())) {
            throw new RuntimeException("Wrong password");
        }
        return userByUsername;
    }

    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(12));
    }

    private boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
