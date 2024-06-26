/*
//package com.example.api.jwt;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//@RequiredArgsConstructor
//public class JwtFilter extends OncePerRequestFilter {
//
//    public final JwtUtil jwtUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        String jwt = resolveToken(request);
//        if (StringUtils.hasText(jwt) && jwtUtil.validateToken(jwt)) {
//            String userId = jwtUtil.getUserIdFromToken(jwt);
//            Authentication authentication = new UsernamePasswordAuthenticationToken(userId, null, new ArrayList<>());
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//        filterChain.doFilter(request, response);
//    }
//
//    private String resolveToken(HttpServletRequest request) {
//        String bearerToken = request.getHeader(jwtUtil.getHeader());
//        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//}*/
