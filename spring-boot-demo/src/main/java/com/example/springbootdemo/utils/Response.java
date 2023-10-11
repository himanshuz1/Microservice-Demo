package com.example.springbootdemo.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response {

    private boolean isError;

    private String message;


    private Object responseObj;

    private String errorCode;

    private Object errorObj;
}
