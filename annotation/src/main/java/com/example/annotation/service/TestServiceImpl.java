package com.example.annotation.service;

import com.example.annotation.rand.RandGenerator;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    /**
     * Annotation initialize rand value only on postProcessBeforeInitialization of TestService bean
     */
    @RandGenerator(min = 1, max = 10)
    private int rand;

    @Override
    public void execute() {
        for (int i = 0; i < rand; i++) {
            System.out.println("Hello world");
        }
    }
}
