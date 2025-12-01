package com.example.Ventas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Corsconfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Aplica a TODAS las rutas
                        .allowedOrigins("*") // Permite CUALQUIER origen (incluyendo tu puerto 5174)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite TODOS los métodos
                        .allowedHeaders("*"); // Permite TODOS los encabezados
            }
        };
    }
}