package com.example.rabbitmqproducer.adapters;

import com.example.rabbitmqproducer.config.AppProperties;
import com.example.rabbitmqproducer.models.MyMessage;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQAdapter {
    private final RabbitTemplate rabbitTemplate;

    private final AppProperties properties;

    public RabbitMQAdapter(RabbitTemplate rabbitTemplate, AppProperties properties) {
        this.rabbitTemplate = rabbitTemplate;
        this.properties = properties;
    }

    public void sendRequestMessage(MyMessage message){
        try {
            rabbitTemplate.convertAndSend(
                    properties.getDirectExchange(),
                    properties.getDirectQueue(),
                    message
            );
        } catch (AmqpException e){
            System.out.println("Failed to enqueue the message");
        }
    }
}
