package com.example.uzumnotificationservice.notificaiton.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequestDto
{
    private String phoneNumber;
    private String message;
    private NotificationType notificationType;
}
