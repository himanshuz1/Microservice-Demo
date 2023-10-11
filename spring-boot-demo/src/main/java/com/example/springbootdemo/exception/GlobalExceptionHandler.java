package com.example.springbootdemo.exception;

import com.example.springbootdemo.utils.ResponseHandler;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex, @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        List<ObjectError> listOfError = ex.getBindingResult().getAllErrors();
        Map<String, String> errorMap = new TreeMap<>();
        listOfError.forEach(objectError -> {
            FieldError fieldError = (FieldError) objectError;
            errorMap.put(fieldError.getField(), objectError.getDefaultMessage());
        });
        return ResponseHandler.generateRestApiResponse(HttpStatus.BAD_REQUEST, true, "Validation Failed",
                "REQUEST_VALIDATION_FAILED", Optional.empty(), errorMap);
    }
}
