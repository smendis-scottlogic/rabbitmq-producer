package com.example.rabbitmqproducer.services;

import com.example.rabbitmqproducer.adapters.RabbitMQAdapter;
import com.example.rabbitmqproducer.models.MyMessage;
import org.springframework.stereotype.Service;

@Service
public class QueueService {
    private final RabbitMQAdapter adapter;

    public QueueService(RabbitMQAdapter adapter) {
        this.adapter = adapter;
    }

    public void sendRequestMessage(MyMessage message){
        System.out.println("Sending message: "+message.toString());
        adapter.sendRequestMessage(message);
    }
}
