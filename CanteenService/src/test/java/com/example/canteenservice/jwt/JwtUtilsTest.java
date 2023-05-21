package com.example.canteenservice.jwt;

import com.example.canteenservice.dto.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilsTest {

    private JwtUtils jwtUtils;

    @BeforeEach
    void setUp() {
        jwtUtils = new JwtUtils();
        jwtUtils.setSECRET_KEY("AKeyForJWTThatIsVerySecretAndHas32CharactersWithSomeNumbers1234AndSomeSymbols@#");
        jwtUtils.setEXPIRATION_TIME(3600); // 1 hour
    }

    @Test
    void testGenerateToken() {
        // Prepare test data
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("john_doe");
        userDTO.setRole("ROLE_USER");

        // Generate token
        String token = jwtUtils.generateToken(userDTO);

        // Assert token is not empty
        assertNotNull(token);

        // Assert token can be parsed and contains expected claims
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(jwtUtils.getSignInKey())
                .build()
                .parseClaimsJws(token);

        assertEquals("john_doe", claims.getBody().getSubject());
        assertEquals("john_doe", claims.getBody().get("username"));
        assertEquals("ROLE_USER", claims.getBody().get("role"));
    }

    @Test
    void testVerifyTokenWithValidTokenAndMatchingUserDetails() {
        // Prepare test data
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("john_doe");
        userDTO.setPassword("password");
        UserDetails userDetails = new UserDetailsImpl(userDTO);
        // Generate token
        String token = generateValidToken("john_doe");

        // Verify token
        boolean result = jwtUtils.verifyToken(token, userDetails);

        // Assert result is true
        assertTrue(result);
    }

    @Test
    void testVerifyTokenWithValidTokenAndMismatchingUserDetails() {
        // Prepare test data
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("john_doe");
        userDTO.setPassword("password");
        UserDetails userDetails = new UserDetailsImpl(userDTO);
        // Generate token for a different user
        String token = generateValidToken("another_user");

        // Verify token
        boolean result = jwtUtils.verifyToken(token, userDetails);

        // Assert result is false
        assertFalse(result);
    }

    @Test
    void testVerifyTokenWithExpiredToken() {
        // Prepare test data
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("john_doe");
        userDTO.setPassword("password");
        UserDetails userDetails = new UserDetailsImpl(userDTO);

        // Generate an expired token
        String token = generateExpiredToken("john_doe");

        // Verify token
        boolean result = jwtUtils.verifyToken(token, userDetails);

        // Assert result is false
        assertFalse(result);
    }

    // Helper method to generate a valid token
    private String generateValidToken(String username) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10); // Token expires in 10 seconds
        Date expirationDate = calendar.getTime();

        Claims claims = Jwts.claims();
        claims.put(Claims.SUBJECT, username);
        claims.put("username", username);
        claims.put("role", "ROLE_USER");

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(expirationDate)
                .signWith(jwtUtils.getSignInKey())
                .compact();
    }

    // Helper method to generate an expired token
    private String generateExpiredToken(String username) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, -10); // Token expired 10 seconds ago
        Date expirationDate = calendar.getTime();

        Claims claims = Jwts.claims();
        claims.put(Claims.SUBJECT, username);
        claims.put("username", username);
        claims.put("role", "ROLE_USER");

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(expirationDate)
                .signWith(jwtUtils.getSignInKey())
                .compact();
    }
}
