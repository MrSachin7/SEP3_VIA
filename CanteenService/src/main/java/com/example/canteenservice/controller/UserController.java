package com.example.canteenservice.controller;

import com.example.canteenservice.dto.UserDTO;
import com.example.canteenservice.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity createUser(@RequestBody UserDTO userDTO) {
        try {

            UserDTO addedUser = userService.createUser(userDTO);
            return ResponseEntity.ok(addedUser);
        } catch (Exception e) {
            return ResponseUtil.internalServerError(e);
        }
    }

    @GetMapping(value = "/users/{username}")
    @ResponseBody
    public ResponseEntity getUser(@PathVariable String username) {
        try {
            UserDTO userFromServer = userService.getUserByUsername(username);
            return ResponseEntity.ok(userFromServer);
        } catch (Exception e) {
            return ResponseUtil.internalServerError(e);
        }
    }

    @PostMapping(value = "/users/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO) {
        try {
         UserDTO token = userService.authenticateUser(userDTO);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseUtil.notFound(e);
        }
    }

}
