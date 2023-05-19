package com.example.canteenservice.grpc.clients;

import com.example.canteenservice.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserClient {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserByUsername(String username);
}
