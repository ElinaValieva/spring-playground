package com.spring.config.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration()
@ConfigurationProperties(prefix = "default.dev")
@PropertySource(value = "classpath:dev.properties")
public class DevConfiguration extends BaseConfiguration {
}
