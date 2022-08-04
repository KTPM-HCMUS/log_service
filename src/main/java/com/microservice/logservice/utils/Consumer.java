package com.microservice.logservice.utils;

import com.microservice.logservice.config.RabbitMQConfiguration;
import com.microservice.logservice.model.LogModel;
import com.microservice.logservice.service.LogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private LogService logService;

    @RabbitListener(queues = RabbitMQConfiguration.QUEUE)
    public void saveLogIntoDatabase(LogModel logModel){
        logService.saveLog(logModel);
        System.out.println(logModel);
    }
}
