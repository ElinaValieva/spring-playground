package com.example.annotation;

import com.example.annotation.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AnnotationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AnnotationApplication.class, args);
        run.getBeanFactory().getBean(TestService.class).execute();
    }

}
