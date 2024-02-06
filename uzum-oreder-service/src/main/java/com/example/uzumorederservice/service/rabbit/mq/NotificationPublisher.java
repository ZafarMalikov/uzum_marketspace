package com.example.uzumorederservice.service.rabbit.mq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationPublisher
{
    private final AmqpTemplate template;

    public void publish( String message )
    {
        template.convertAndSend(RabbitMQConfig.NOTIFICATION_EXCHANGE_NAME,
                RabbitMQConfig.NOTIFICATION_BINDING_KEY
                ,message);
    }
}
