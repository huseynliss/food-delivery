package com.example.foodprojectmain.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogoutHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        // Invalidate the session
        request.getSession().invalidate();

        // Clear the security context
        SecurityContextHolder.clearContext();

        // Perform other custom logic, if desired

        // Redirect the user to the desired location after logout
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("/");
    }
}

