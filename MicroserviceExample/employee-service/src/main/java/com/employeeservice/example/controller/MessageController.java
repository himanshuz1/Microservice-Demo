package com.employeeservice.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

    @Value("${emp.service.app.message}")
    private String message;

    @GetMapping("/api/v1/message")
    public String getMessage() {
        return message;
    }
}
