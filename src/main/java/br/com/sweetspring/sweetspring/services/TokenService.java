package br.com.sweetspring.sweetspring.services;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.sweetspring.sweetspring.entity.User;

@Service
public class TokenService {
    public String GenerateToken(User dto){
        return JWT.create()
                .withSubject(dto.getUsername())
                .withClaim("Id", dto.getId())
                .withExpiresAt(LocalDateTime.now()
                .plusMinutes(60)
                .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("SECRETO"));
    }

    public String getSubject(String token){
        return JWT.require(Algorithm.HMAC256("SECRETO"))
                .build().verify(token).getSubject();
    }
}
