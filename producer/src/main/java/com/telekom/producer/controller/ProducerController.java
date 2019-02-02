package com.telekom.producer.controller;

import com.telekom.producer.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: ElinaValieva on 02.02.2019
 */
@RestController
public class ProducerController {

    @Autowired
    private Producer producer;

    @RequestMapping("/send")
    public String sendMsg(@RequestParam("msg")String msg){
        producer.produceMsg(msg);
        return "Done";
    }

}
