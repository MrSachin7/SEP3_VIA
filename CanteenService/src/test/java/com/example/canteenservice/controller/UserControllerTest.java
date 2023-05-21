package com.example.canteenservice.controller;

import com.example.canteenservice.dto.UserDTO;
import com.example.canteenservice.jwt.JwtUtils;
import com.example.canteenservice.services.impl.UserServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userServiceImpl;

    @MockBean
    private JwtUtils jwtUtils;

    private UserDTO mockUserDTO;

    @BeforeEach
    void setUp() {
        mockUserDTO = new UserDTO();
        mockUserDTO.setUsername("testUsername");
        mockUserDTO.setPassword("testPassword");
        mockUserDTO.setRole("testRole");
        mockUserDTO.setFirstName("testFirstName");
        mockUserDTO.setLastName("testLastName");
        jwtUtils.setSECRET_KEY("AKeyForJWTThatIsVerySecretAndHas32CharactersWithSomeNumbers1234AndSomeSymbols@#");
        when(jwtUtils.verifyToken(anyString(), any())).thenReturn(true);
    }



    // There is some issue with the token. but this is how the test should have been written
    @Test
    void void_shouldReturnUserDTO_whenCreateUser() throws Exception {
        when(userServiceImpl.createUser(any(UserDTO.class))).thenReturn(mockUserDTO);
        // Perform a GET request to /users/1 and validate the response
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Jwt-Key", "AKeyForJWTThatIsVerySecretAndHas32CharactersWithSomeNumbers1234AndSomeSymbols@#")
                        .content("{\"firstName\":\"testFirstName\",\"lastName\":\"testLastName\",\"username\":\"testUsername\",\"password\":\"testPassword\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("testFirstName"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("testLastName"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("testUsername"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("testPassword"));
    }
}