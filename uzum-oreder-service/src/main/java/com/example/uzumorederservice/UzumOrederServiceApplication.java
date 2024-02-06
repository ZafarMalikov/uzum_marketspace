package com.example.uzumorederservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UzumOrederServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UzumOrederServiceApplication.class, args);
    }

}
