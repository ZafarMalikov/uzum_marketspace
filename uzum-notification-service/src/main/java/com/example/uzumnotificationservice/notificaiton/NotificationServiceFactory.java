package com.example.uzumnotificationservice.notificaiton;

import com.example.uzumnotificationservice.notificaiton.dto.NotificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NotificationServiceFactory
{
    private final List<AbstractNotificationService> notificationServices;

    public AbstractNotificationService getService( NotificationType notificationType )
    {
        for( AbstractNotificationService service : notificationServices )
        {
            if( service.supports( notificationType ) )
            {
                return service;
            }
        }
            throw new IllegalArgumentException( "%s notification type is not supported ".formatted( notificationType ) );
    }
}
