package com.codingshuttle.anujTutorial.tutorial.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    @ConditionalOnProperty(name = "app.mode", havingValue = "dev")
    public String devMode() {
        return "dev";
    }

    @Bean
    @ConditionalOnProperty(name = "app.mode", havingValue = "prod")
    public String prodMode() {
        return "prod";
    }

    @Bean
    @ConditionalOnProperty(name = "app.mode", havingValue = "test")
    public String testMode() {
        return "test";
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
