package com.example.annotation.service;

import com.example.annotation.monitor.Monitor;
import com.example.annotation.rand.RandGenerator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Annotation for getting monitor information in postProcessAfterInitialization of TestService bean
 */
@Log4j2
@Monitor
@Service
public class TestServiceImpl implements TestService {

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
