package com.microservice.logservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfiguration {
    public static final String EXCHANGE = "exchange";
    public static final String QUEUE = "queue.Log";
    public static final String BINDING = "binding.Log";

    @Bean
    Queue queueA(){
        return new Queue(QUEUE, false);
    }

    @Bean
    DirectExchange exchange(){
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Binding binding(Queue a, DirectExchange exchange){
        return BindingBuilder.bind(a)
                .to(exchange)
                .with(BINDING);
    }

    @Bean
    MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
