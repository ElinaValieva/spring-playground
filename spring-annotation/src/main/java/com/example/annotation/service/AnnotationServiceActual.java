package com.example.annotation.service;

import com.example.annotation.monitor.Monitor;
import com.example.annotation.time.Time;

/**
 * Annotation for getting monitor information in postProcessAfterInitialization of TestService bean
 */
@Monitor
public class AnnotationServiceActual extends AnnotationServiceDeprecated implements AnnotationService {

    @Override
    void init() {
        System.out.println("Hello from actual service");
    }

    /**
     * Annotation for calculating execution method time
     */
    @Time
    @Override
    public void execute() {
        System.out.println("I can't generate value ..");
    }
}
