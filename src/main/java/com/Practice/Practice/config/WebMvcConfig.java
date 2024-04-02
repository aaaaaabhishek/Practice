package com.Practice.Practice.config;

import com.Practice.Practice.Component.PostMethodInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final PostMethodInterceptor postMethodInterceptor;

    public WebMvcConfig(PostMethodInterceptor postMethodInterceptor) {
        this.postMethodInterceptor = postMethodInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(postMethodInterceptor).addPathPatterns("/**");
    }
}
