package com.spring.actuator.custom_metric.configuration;


import com.spring.actuator.custom_metric.common.URLs;
import com.spring.actuator.custom_metric.model.Statistic;
import com.spring.actuator.custom_metric.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;


@Component
@Endpoint(id = URLs.ENDPOINT)
public class StatusMetric {

    @Autowired
    private StatisticService statisticService;

    @ReadOperation
    public Statistic getStatus() {
        return statisticService.initStatistic();
    }
}
