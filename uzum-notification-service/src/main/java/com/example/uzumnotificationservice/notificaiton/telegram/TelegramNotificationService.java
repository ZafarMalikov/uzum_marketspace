package com.example.uzumnotificationservice.notificaiton.telegram;

import com.example.uzumnotificationservice.notificaiton.AbstractNotificationService;
import com.example.uzumnotificationservice.notificaiton.dto.NotificationRequestDto;
import com.example.uzumnotificationservice.notificaiton.dto.NotificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelegramNotificationService extends AbstractNotificationService
{

    @Override
    public boolean supports( NotificationType notificationType )
    {
        return notificationType == NotificationType.TELEGRAM;

    }

    @Override
    public void sendNotification( NotificationRequestDto requestDto )
    {
        System.out.println( requestDto );
    }
}
