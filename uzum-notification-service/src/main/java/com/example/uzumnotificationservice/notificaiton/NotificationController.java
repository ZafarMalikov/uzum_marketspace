package com.example.uzumnotificationservice.notificaiton;

import com.example.uzumnotificationservice.notificaiton.dto.NotificationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/notification" )
@RequiredArgsConstructor
public class NotificationController
{
    private final NotificationServiceFactory notificationServiceFactory;

    @PostMapping
    public void sendNotification( @RequestBody NotificationRequestDto requestDto )
    {
        AbstractNotificationService service = notificationServiceFactory
            .getService( requestDto.getNotificationType() );

        service.sendNotification( requestDto );
    }
}
