package com.example.canteenservice.jwt;

import com.example.canteenservice.dto.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Value("${jwt.expiration}")
    private long EXPIRATION_TIME;

    public String generateToken(UserDTO userDTO) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 30);
        Date expirationDate = calendar.getTime();


        Claims claims = Jwts.claims();
        claims.put(Claims.SUBJECT, userDTO.getUsername());
        claims.put("username", userDTO.getUsername());
        claims.put("role", userDTO.getRole());

        return Jwts.builder().setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignInKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    public boolean verifyToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
    private boolean isTokenExpired(String token) {
        Claims parsed = parseToken(token);
        return parsed.getExpiration().before(new Date());

    }
    public String getUsernameFromToken(String token) {
        Claims parsed = parseToken(token);
        return parsed.getSubject();
    }

    private Claims parseToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();

    }
}
