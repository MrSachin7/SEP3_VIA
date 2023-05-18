package com.example.canteenservice.controller;

import com.example.canteenservice.dto.UserDTO;
import com.example.canteenservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/createUser")
    public ResponseEntity createUser(@RequestBody UserDTO userDTO) {
        try {

            UserDTO addedUser = userService.createUser(userDTO);
            return ResponseEntity.ok(addedUser);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/user/{username}")
    @ResponseBody
    public ResponseEntity getUser(@PathVariable String username) {
        try {
            System.out.println("username = " + username);

            UserDTO userFromServer = userService.getUserByUsername(username);
            return ResponseEntity.ok(userFromServer);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
