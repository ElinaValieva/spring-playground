package com.spring.producer.controller;

import com.spring.producer.component.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * author: ElinaValieva on 02.02.2019
 */
@Controller
public class ProducerController {

    private final Producer producer;

    @Autowired
    public ProducerController(Producer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedDelay = 5000)
    public void sendMsg() {
        String msg = "Generated value: " + Math.random();
        producer.produceMsg(msg);
    }

}
