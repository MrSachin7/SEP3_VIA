package com.example.canteenservice.controller;

import com.example.canteenservice.dto.UserDTO;
import com.example.canteenservice.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userServiceImpl;

    private UserDTO mockUserDTO;

    @BeforeEach
    void setUp() {
        mockUserDTO = new UserDTO();
        mockUserDTO.setUsername("testUsername");
        mockUserDTO.setPassword("testPassword");
        mockUserDTO.setRole("testRole");
        mockUserDTO.setFirstName("testFirstName");
        mockUserDTO.setLastName("testLastName");
    }

    @Test
    void void_shouldReturnUserDTO_whenGetUserByUsername() throws Exception {
        when(userServiceImpl.getUserByUsername("testUsername")).thenReturn(mockUserDTO);
        // Perform a GET request to /users/1 and validate the response
        mockMvc.perform(MockMvcRequestBuilders.get("/users/testUsername"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("testUsername"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("testPassword"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("testRole"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("testFirstName"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("testLastName"));

    }

    @Test
    void void_shouldReturnUserDTO_whenCreateUser() throws Exception {
        when(userServiceImpl.createUser(any(UserDTO.class))).thenReturn(mockUserDTO);
        // Perform a GET request to /users/1 and validate the response
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"testFirstName\",\"lastName\":\"testLastName\",\"username\":\"testUsername\",\"password\":\"testPassword\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("testFirstName"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("testLastName"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("testUsername"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("testPassword"));
    }
}