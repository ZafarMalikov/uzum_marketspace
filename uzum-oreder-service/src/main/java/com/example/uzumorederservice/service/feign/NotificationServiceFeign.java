package com.example.uzumorederservice.service.feign;

import com.example.uzumorederservice.service.feign.dto.NotificationRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient( name = "uzum-notification-service" )
public interface NotificationServiceFeign
{
    @PostMapping( "/api/v1/notification" )
    void sendSms( @RequestBody NotificationRequestDto notificationRequestDto );
}
