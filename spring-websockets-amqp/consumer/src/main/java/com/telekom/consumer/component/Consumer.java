package com.telekom.consumer.component;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.telekom.consumer.common.URL.TOPIC_PUBLIC;

/**
 * author: ElinaValieva on 02.02.2019
 */
@Component
public class Consumer {

    private final SimpMessagingTemplate template;

    private Logger logger = Logger.getLogger(Consumer.class.getName());

    @Autowired
    public Consumer(SimpMessagingTemplate template) {
        this.template = template;
    }

    @RabbitListener(queues = "${jsa.rabbitmq.queue}")
    public void receivedMessage(String msg) {
        logger.log(Level.INFO, "Received Message: " + msg);
        template.convertAndSend(TOPIC_PUBLIC, msg);
    }
}
