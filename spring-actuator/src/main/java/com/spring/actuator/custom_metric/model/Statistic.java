package com.spring.actuator.custom_metric.model;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Statistic {

    private Long timeTransformation;

    private Integer cntCommands;

    private Integer cntInterpretedNodes;

    private Integer cntNodes;

    private Integer cntIgnoredNodes;
}
