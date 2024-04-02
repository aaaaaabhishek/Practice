package com.Practice.Practice.Component;

import com.Practice.Practice.Dto.CompanyDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PostMethodInterceptor implements HandlerInterceptor {
    private final ObjectMapper objectMapper;

    public PostMethodInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            // Convert request payload to object
            CompanyDto companyDto = objectMapper.readValue(request.getInputStream(), CompanyDto.class);
            // Inspect the webSiteURL field and set to null if URL is not valid
            if (!isValidUrl(companyDto.getWebSiteURL())) {
                companyDto.setWebSiteURL(null);
                // Convert back to JSON and set as request payload
                String jsonPayload = objectMapper.writeValueAsString(companyDto);
                request.setAttribute("jsonPayload", jsonPayload);
            }
        }
        return true; // continue processing the request
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Do nothing after handling the request
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Do nothing after completing the request
    }

    private boolean isValidUrl(String url) {
        // Implement your URL validation logic here
        // For demonstration purposes, this example considers any non-empty string as a valid URL
        return url != null && !url.isEmpty();
    }
}
