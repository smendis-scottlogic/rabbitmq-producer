package com.example.rabbitmqproducer.controllers;

import com.example.rabbitmqproducer.models.MyMessage;
import com.example.rabbitmqproducer.services.QueueService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    private final QueueService queueService;

    public ProducerController(QueueService queueService) {
        this.queueService = queueService;
    }

    @PostMapping("/produce")
    public String produce(@RequestBody MyMessage message){
        this.queueService.sendRequestMessage(message);
        return "Message Sent";
    }
}
