package com.spring.producer.component;

import com.spring.producer.controller.ProducerController;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * author: ElinaValieva on 02.02.2019
 */
@Component
public class Producer {

    private final AmqpTemplate amqpTemplate;

    private Logger logger = Logger.getLogger(ProducerController.class.getName());

    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;

    @Value("${jsa.rabbitmq.routingkey}")
    private String routingKey;

    @Autowired
    public Producer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void produceMsg(String msg) {
        amqpTemplate.convertAndSend(exchange, routingKey, msg);
        logger.log(Level.FINE, "Generated value: " + msg);
    }
}
