package com.example.canteenservice.services.impl;

import com.example.canteenservice.dto.UserDTO;
import com.example.canteenservice.grpc.clients.UserClient;
import com.example.canteenservice.jwt.JwtUtils;
import com.example.canteenservice.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserClient userClient;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(UserClient userClient, JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.userClient = userClient;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return userClient.createUser(userDTO);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return userClient.getUserByUsername(username);
    }

    @Override
    public String authenticateUser(UserDTO userDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDTO.getUsername(),
                        userDTO.getPassword()
                )
        );
        getUserByUsername(userDTO.getUsername());
        return jwtUtils.generateToken(userDTO.getUsername());
    }
}
