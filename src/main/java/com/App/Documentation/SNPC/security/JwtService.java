package com.App.Documentation.SNPC.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Service

public class JwtService {
    static  final long EXPIRATIONTIME=86400000;
    static  final String PREFIX="Bearer ";
    static  final Key key= Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public  String getToken(String username){
        String token= Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRATIONTIME))
                .signWith(key)
                .compact();
        return token;
    }
    public String getAuthUser(HttpServletRequest request){
        String token=request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println(token);
        if (token !=null){
            String user=Jwts.parser()
                    .verifyWith((SecretKey)key )
                    .build()
                    .parseClaimsJws(token.replace(PREFIX,""))
                    .getBody()
                    .getSubject();

            if(user !=null) return user;
        }
        return null;
    }

}
