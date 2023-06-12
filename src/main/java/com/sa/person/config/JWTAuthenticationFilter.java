package com.sa.person.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.person.service.UserDetailsImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Collections;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author ramip
 */

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    
   @Override
   public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException{    
    AuthCredentials authCredential = new AuthCredentials();
        
        try{
            authCredential = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        }catch (IOException e){
        }
        
        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                authCredential.getEmail(),
                authCredential.getPassword(),
                Collections.emptyList()
        );
        
        return getAuthenticationManager().authenticate(usernamePAT);
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, 
                                           HttpServletResponse response,
                                           FilterChain chain,
                                           Authentication authResult) throws IOException, ServletException{
    
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetails.getName(), userDetails.getUsername());
        
        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().flush();
        
        super.successfulAuthentication(request, response, chain, authResult);
        
    }
}
