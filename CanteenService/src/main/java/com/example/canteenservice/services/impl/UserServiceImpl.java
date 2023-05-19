package com.example.canteenservice.services.impl;

import com.example.canteenservice.dto.UserDTO;
import com.example.canteenservice.grpc.clients.UserClient;
import com.example.canteenservice.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserClient userClient;


    public UserServiceImpl(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return userClient.createUser(userDTO);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return userClient.getUserByUsername(username);
    }
}
