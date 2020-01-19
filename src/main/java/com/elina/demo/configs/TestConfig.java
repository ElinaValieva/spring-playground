package com.elina.demo.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration()
@ConfigurationProperties(prefix = "default.test", ignoreInvalidFields = true)
@PropertySource(value = "classpath:test.properties")
public class TestConfig extends BaseConfig {
}
