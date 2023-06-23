package com.app.server.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Collections;

public class TokenUtil {
    public static Authentication decode(HttpServletRequest request) {
        if (request.getHeader("Authorization").equals("Bearer password")) {
            return new UsernamePasswordAuthenticationToken("user", null, Collections.emptyList());
        }
        return null;
    }
}
