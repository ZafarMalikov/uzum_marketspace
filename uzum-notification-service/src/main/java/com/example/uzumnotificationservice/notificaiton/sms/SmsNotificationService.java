package com.example.uzumnotificationservice.notificaiton.sms;

import com.example.uzumnotificationservice.eskiz.EskizFeign;
import com.example.uzumnotificationservice.eskiz.dt.EskizSendSmsDto;
import com.example.uzumnotificationservice.eskiz.dto.EskizAuthResponseDto;
import com.example.uzumnotificationservice.notificaiton.AbstractNotificationService;
import com.example.uzumnotificationservice.notificaiton.dto.NotificationRequestDto;
import com.example.uzumnotificationservice.notificaiton.dto.NotificationType;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsNotificationService extends AbstractNotificationService
{
    @Value( "${uzum-notificaiton-service.eskiz.access-token}" )
    private String accessToken;
    private final EskizFeign eskizFeign;

    @Override
    public boolean supports( NotificationType notificationType )
    {
        return notificationType == NotificationType.SMS;
    }

    @Override
    public void sendNotification( NotificationRequestDto requestDto )
    {
        EskizSendSmsDto eskizSendSmsDto = new EskizSendSmsDto( requestDto.getPhoneNumber(), requestDto.getMessage() );
        try
        {
            eskizFeign.sendSms( eskizSendSmsDto, accessToken );
        }
        catch( FeignException.Unauthorized e )
        {
            EskizAuthResponseDto eskizAuthResponseDto = eskizFeign.refreshToken( accessToken );
            accessToken = "Bearer " + eskizAuthResponseDto.getData().get( "token" );
            eskizFeign.sendSms( eskizSendSmsDto, accessToken );
        }
    }
}
