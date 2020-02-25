package com.elina.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public BaseConfig getConfig(String name) {
        return name.equals("test") ? getTest() : getDev();
    }

    @Bean
    BaseConfig getTest() {
        return new TestConfig();
    }

    @Bean
    BaseConfig getDev() {
        return new DevConfig();
    }
}
