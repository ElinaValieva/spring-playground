package com.spring.actuator.custom_metric.service;


import com.spring.actuator.custom_metric.model.Statistic;
import org.springframework.stereotype.Service;


@Service
public class StatisticService {

    public Statistic initStatistic() {
        return Statistic.builder()
                .cntCommands(10)
                .cntIgnoredNodes(20)
                .cntInterpretedNodes(80)
                .cntNodes(100)
                .timeTransformation(100L).build();
    }
}
