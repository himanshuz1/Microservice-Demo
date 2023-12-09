package com.example.employee.controller;

import com.example.employee.openfeign.DepartmentFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final WebClient webClient;


    @Autowired
    private DepartmentFeignClient departmentFeignClient;

    @GetMapping("{name}")
    public ResponseEntity<Object> testWebClientCall(@PathVariable("name") String name) {
       //String response = webClient.get().uri("http://localhost:2000/api/v1/himanshu/test").retrieve().bodyToMono(String.class).block();
        ResponseEntity<String> response = departmentFeignClient.testDepartment(name);
        log.debug("responseEntity from department service==={}", response);
        return ResponseEntity.ok("response from department service in emp service===" + response + "__________" + name);
    }
}
