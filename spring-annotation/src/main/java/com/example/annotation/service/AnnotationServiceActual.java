package com.example.annotation.service;

import com.example.annotation.monitor.Monitor;

/**
 * Annotation for getting monitor information in postProcessAfterInitialization of TestService bean
 */
@Monitor
public class AnnotationServiceActual extends AnnotationServiceDeprecated implements AnnotationService {

    @Override
    void init() {
        System.out.println("Hello from actual service");
    }

    @Override
    public void execute() {
        System.out.println("I can't generate value ..");
    }
}
