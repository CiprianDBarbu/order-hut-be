package com.cbar.orderhutbe.security;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;

public class JwtTokenFilter extends OncePerRequestFilter {

    public final JwtTokenProvider tokenProvider;

    public JwtTokenFilter(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token != null) {
            try {
                Claims claims = tokenProvider.getClaimsFromToken(token.split(" ")[1]);
                if(!claims.getExpiration().before(new Date())) {
                    Authentication authentication = tokenProvider.getAuthentication(claims.getSubject());
                    if (authentication.isAuthenticated()) {
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            } catch (RuntimeException e) {
                try {
                    SecurityContextHolder.clearContext();
                    response.setContentType("application/json");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().println(
                            new JSONObject().put("exception", "expired or invalid JWT token " + e.getMessage())
                    );
                    } catch (IOException | JSONException e1) {
                        e1.printStackTrace();
                    }
                    return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
