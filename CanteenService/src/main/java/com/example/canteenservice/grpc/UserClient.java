package com.example.canteenservice.grpcClient;

import com.example.canteenservice.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
public interface UserClient {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserByUsername(String username);
}
