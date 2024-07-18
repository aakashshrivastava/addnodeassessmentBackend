package com.altassianassessment.backend.configurations;

import jakarta.servlet.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    public Filter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*"); // Allow all origins
        config.addAllowedHeader("*"); // Allow all headers
        config.addAllowedMethod("*"); // Allow all HTTP methods
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
