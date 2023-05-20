package com.example.canteenservice.services;

import com.example.canteenservice.dto.JwtTokenDTO;
import com.example.canteenservice.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserByUsername(String username);

    JwtTokenDTO authenticateUser(UserDTO userDTO);
}
