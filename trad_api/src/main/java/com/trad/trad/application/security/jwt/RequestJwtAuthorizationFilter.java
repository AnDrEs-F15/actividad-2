package com.trad.trad.application.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class RequestJwtAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException
    {
            String authorizationBearerToken =  request.getHeader("Authorization");
            if (authorizationBearerToken!= null && authorizationBearerToken.startsWith("Bearer") ){
                String tokenJwt = authorizationBearerToken.replace("Bearer","");
                UsernamePasswordAuthenticationToken userPath  = TokenUtils.isValidToken(tokenJwt);
                SecurityContextHolder.getContext().setAuthentication(userPath);
            }
            filterChain.doFilter(request,response);
    }
}
