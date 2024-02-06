package com.example.uzumorederservice.service.rabbit.mq;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public final static  String NOTIFICATION_EXCHANGE_NAME="NotificationExchange";
    public final static  String NOTIFICATION_QUEUE_NAME="NotificationQueue";
    public final static  String NOTIFICATION_BINDING_KEY="NotificationQueue";

    @Bean
    public Exchange exchange(){
        return new TopicExchange(NOTIFICATION_EXCHANGE_NAME);
    }

    @Bean
    public Queue queue(){
        return new Queue(NOTIFICATION_QUEUE_NAME);
    }

    @Bean
    public Binding binding(Exchange exchange,Queue queue){
         return BindingBuilder
                 .bind(queue)
                 .to(exchange)
                 .with(NOTIFICATION_BINDING_KEY)
                 .noargs();
    }

}
