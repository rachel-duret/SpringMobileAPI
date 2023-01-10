package com.mobile.SpringMobileAPI.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtGenerator {

    public static final Key key = new SecretKeySpec(Base64.getDecoder().decode(JwtConstants.SECRET), SignatureAlgorithm.HS256.getJcaName());
    public String generateToken(Authentication authentication){
//        Build JWT token
        return Jwts.builder()
                .setSubject(authentication.getName())
                .setExpiration(new Date( System.currentTimeMillis() + JwtConstants.EXPIRE_IN_MS))
                .signWith(key)
                .compact();

    }

    public String getUsernameFromJWT(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e){
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
        }
    }
}
