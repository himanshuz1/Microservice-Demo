package com.example.springbootdemo.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> generateRestApiResponse(HttpStatus httpStatus, boolean isError, String message, String errorCode, Object responseObj, Object errorObject) {
        Response response = new Response();
        response.setError(isError);
        response.setMessage(message);
        response.setErrorCode(errorCode);
        response.setResponseObj(responseObj);
        response.setErrorObj(errorObject);
        return new ResponseEntity<>(response, httpStatus);
    }
}
