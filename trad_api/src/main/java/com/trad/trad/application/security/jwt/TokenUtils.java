package com.trad.trad.application.security.jwt;

import com.trad.trad.domain.exception.TradAppException;
import com.trad.trad.domain.exception.TradAppExceptionMessage;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

public class TokenUtils {
    @Value("${token.signing.key}")
    private static String TOKEN;
    private static String  KEY = "PRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBAPRUEBA";

    public static String createToken (String usernameOrEmail) {
        return Jwts
                .builder()
                .setSubject(usernameOrEmail)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 48 ))
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
    }

    public static UsernamePasswordAuthenticationToken isValidToken (String token ){
        System.out.println(isTokenExpired(token));
        try {
            if(isTokenExpired(token)){
                String usernameOrEmail = getClaims(token).getSubject();
                return new UsernamePasswordAuthenticationToken(usernameOrEmail,null , Collections.emptyList());
            }else  return null;

        }catch (JwtException e){
            System.out.println("Error " + e.getMessage() );
            return null;
        }
    }
    public static boolean isTokenExpired (String token){
        System.out.println(getClaims(token).getExpiration());
        System.out.println(new Date());
        return Optional.of(getClaims(token).getExpiration().after(new Date()))
                .orElseThrow(()-> new TradAppException(TradAppExceptionMessage.expiredToken(getClaims(token).getExpiration()), HttpStatus.UNAUTHORIZED));
    }

    public static Claims getClaims (String token){
        return Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token).getBody();
    }
}
