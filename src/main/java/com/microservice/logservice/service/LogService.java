package com.microservice.logservice.service;

import com.microservice.logservice.model.LogModel;
import com.microservice.logservice.repository.LogServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LogService {

    @Autowired
    private LogServiceRepository logServiceRepository;

    @PostMapping()
    public void saveLog(@RequestBody LogModel logModel){
        logServiceRepository.save(logModel);
    }
}
