package com.example.uzumnotificationservice.eskiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EskizAuthResponseDto
{
    private Map<String, String> data;
}
