package com.example.rabbitmqproducer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "app.rabbitmq")
public class AppProperties {
    private String directExchange;

    private String directQueue;

    public String getDirectDeadLetterQueue() {
        return this.directQueue + ".dlq";
    }
}
