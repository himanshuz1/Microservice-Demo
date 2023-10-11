package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "TestController",description = "Test REST Controller for testing")
@RestController
public class TestController {

    @Operation(summary = "Rest Api for testing controller and request body",
            description = "Rest Api for testing controller",
            method = "POST REST API")
    @ApiResponse(description = "201 Created",responseCode = "201")
    @PostMapping("/api/v1/testValidation")
    public ResponseEntity<Object> testValidation(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok("Success");
    }

}
