package com.example.canteenservice.services;

import com.example.canteenservice.dto.UserDTO;
import com.example.canteenservice.grpc.UserClient;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserClient userClient;


    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public UserDTO createUser(UserDTO userDTO) {
        return userClient.createUser(userDTO);
    }

    public UserDTO getUserByUsername(String username) {
        return userClient.getUserByUsername(username);
    }
}
