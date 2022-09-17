package com.limit.service.controller;


import com.limit.service.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LimitController {

    @Autowired
    private ConfigProperties configProperties;

    @GetMapping("/api/v1/properties")
    public Map<String, Object> getProperties() {
        Map<String, Object> response = new HashMap<>();
        response.put("maximum", configProperties.getMaximum());
        response.put("minimum", configProperties.getMinimum());
        return response;
    }

}
