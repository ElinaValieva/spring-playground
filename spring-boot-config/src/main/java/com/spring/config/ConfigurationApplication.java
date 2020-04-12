package com.spring.config;

import com.spring.config.configuration.AppConfiguration;
import com.spring.config.configuration.BaseConfiguration;
import com.spring.config.configuration.DevConfiguration;
import com.spring.config.configuration.TestConfiguration;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@Log4j2
@SpringBootApplication
@EnableConfigurationProperties(value = {DevConfiguration.class, TestConfiguration.class})
public class ConfigurationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigurationApplication.class, args);
        String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
        BaseConfiguration config = applicationContext.getBean(AppConfiguration.class).getConfig(activeProfiles[0]);
        log.info("CONFIG: {}", config.getValue());
    }
}
