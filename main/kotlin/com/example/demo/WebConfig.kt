package com.example.demo

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
classWebConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/api/**")  // Делаем доступными все эндпоинты с префиксом /api/
            .allowedOrigins("http://localhost:5173") // Порт, на котором работает React (измените, если ваш порт отличается)
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Указываем, какие методы разрешены
    }
}
