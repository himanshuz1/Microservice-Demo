package com.example.springbootdemo;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Spring Boot Demo Application for REST API",
        description = "Spring Boot REST Application for testing core components",
        version = "V1",
        summary = "Spring Boot REST Application for testing core components and basics",
        contact = @Contact(
                name = "Himanshu",
                email = "himanshu.gmail.com",
                url = "https://www.google.com/"
        ),
        license = @License(
                url = "https://www.google.com/", name = "Apache 2.0", identifier = "Apache Spring Boot"
        )), externalDocs = @ExternalDocumentation(url = "https://www.google.com/", description = "Facebook docs")
)
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}
