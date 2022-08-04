package com.microservice.logservice.controller;

import com.microservice.logservice.config.RabbitMQConfiguration;
import com.microservice.logservice.model.LogModel;
import com.microservice.logservice.service.LogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/log")
public class LogController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private LogService logService;

    @PostMapping()
    public void saveLog(@RequestBody LogModel logModel){
        rabbitTemplate.convertAndSend(RabbitMQConfiguration.EXCHANGE, RabbitMQConfiguration.BINDING, logModel);
    }


}
