package com.actuator.server.configuration;


import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
public class SecuritySecureConfig {

    private final String adminContextPath;

    public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChainSecure(ServerHttpSecurity http) {
        return http.authorizeExchange()
                .pathMatchers(adminContextPath + "/assets/**").permitAll()
                .pathMatchers(adminContextPath + "/login").permitAll()
                .anyExchange().authenticated()
                .and().formLogin().loginPage(adminContextPath + "/login")
                .and().logout().logoutUrl(adminContextPath + "/logout")
                .and().httpBasic()
                .and().csrf().disable().build();

    }
}