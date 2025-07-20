package com.urugondavishnu.store.services;

import com.urugondavishnu.store.config.JwtConfig;
import com.urugondavishnu.store.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Service
public class JwtService {
    private final JwtConfig jwtConfig;

    public Jwt generateAccessToken(User user){
        return generateToken(user, jwtConfig.getAccessTokenExpiration());
    }

    public Jwt generateRefreshToken(User user){
        return generateToken(user, jwtConfig.getRefreshTokenExpiration());
    }

    private Jwt generateToken(User user, long tokenExpiration) {

        var claims = Jwts.claims()
                .subject(user.getId().toString())
                .add("email", user.getEmail())
                .add("name", user.getName())
                .add("role", user.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * tokenExpiration))
                .build();

        return new Jwt(claims, jwtConfig.getSecretKey());
    }

//    public boolean validateToken(String token){
//        try{
//            var claims = getClaims(token);
//
//
//        } catch(JwtException ex){
//            return false;
//        }
//    }

    private Claims getClaims(String token) {
        var claims = Jwts.parser()
                .verifyWith(jwtConfig.getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims;
    }

//    public Long getUserIdFromToken(String token){
//        return Long.valueOf(getClaims(token).getSubject()) ;
//    }

//    public Role getRoleFromToken(String token){
//        return Role.valueOf(getClaims(token).get("role", String.class));
//    }

    public Jwt parseToken(String token){
        try {
            var claims = getClaims(token);
            return new Jwt(claims, jwtConfig.getSecretKey());
        } catch(JwtException e){
            return null;
        }
    }
}
