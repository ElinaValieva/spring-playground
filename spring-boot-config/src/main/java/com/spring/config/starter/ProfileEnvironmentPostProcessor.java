package com.spring.config.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Random;

public class ProfileEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        environment.addActiveProfile(generateActiveProfile());
    }

    private String generateActiveProfile() {
        return (new Random().nextInt(100) % 2 == 0) ? "dev" : "test";
    }
}
