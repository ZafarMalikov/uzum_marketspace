package com.example.uzumnotificationservice.notificaiton;


import com.example.uzumnotificationservice.notificaiton.dto.NotificationRequestDto;
import com.example.uzumnotificationservice.notificaiton.dto.NotificationType;

public abstract class AbstractNotificationService
{
    public abstract boolean supports( NotificationType notificationType );

    public abstract void sendNotification( NotificationRequestDto notificationRequestDto );
}
