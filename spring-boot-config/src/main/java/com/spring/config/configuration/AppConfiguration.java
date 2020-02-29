package com.spring.config.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    public BaseConfiguration getConfig(String name) {
        return name.equals("test") ? getTest() : getDev();
    }

    @Bean
    BaseConfiguration getTest() {
        return new TestConfiguration();
    }

    @Bean
    BaseConfiguration getDev() {
        return new DevConfiguration();
    }
}
