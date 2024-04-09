package com.cafe.server.security;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.JwtException;

/**
 * Provides a Filter to handle JWT Token from SecurityConfig filterChain
 * Extending OncePerRequestFilter since a database call does not occur more than
 * once
 */
public class JwtTokenFilter extends OncePerRequestFilter {

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
      FilterChain filterChain) throws ServletException, IOException {
    String token = jwtTokenProvider.resolveToken(httpServletRequest);
    try {
      if (token != null && jwtTokenProvider.validateToken(token)) {
        Authentication auth = jwtTokenProvider.getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
      }
    } catch (JwtException jwtException) {
      SecurityContextHolder.clearContext();
      ResponseEntity<Object> responseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body(Map.of("error", jwtException.getMessage()));
      httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
      httpServletResponse.setContentType("application/json");
      httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(responseEntity.getBody()));
      return;
    }

    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }

}