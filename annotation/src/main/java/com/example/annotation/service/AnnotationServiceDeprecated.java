package com.example.annotation.service;

import com.example.annotation.deprecated.DeprecatedService;
import com.example.annotation.monitor.Monitor;
import com.example.annotation.rand.RandGenerator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Annotation to deprecate usage of old version and replace it by new version
 * Done by configuring bean definition in beanFactoryPostProcessor
 */
@Log4j2
@Service
@DeprecatedService(actual = AnnotationServiceActual.class)
public class AnnotationServiceDeprecated implements AnnotationService {

    /**
     * Annotation initialize rand value only on postProcessBeforeInitialization of TestService bean
     */
    @RandGenerator(min = 1, max = 10)
    private int rand;

    @PostConstruct
    void init() {
        log.info("Post construct");
    }

    @Override
    public void execute() {
        log.info("Generated {} random value", rand);
    }
}
