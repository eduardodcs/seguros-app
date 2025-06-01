package com.bank.seguros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.bank.common_web.handler.GlobalExceptionHandler;
import com.bank.seguros.core.vida.usecases.SeguroVidaUseCase;

@Configuration
public class BeansConfig {

     @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    public SeguroVidaUseCase seguroVidaUseCase() {
        return new SeguroVidaUseCase();
    }
}
