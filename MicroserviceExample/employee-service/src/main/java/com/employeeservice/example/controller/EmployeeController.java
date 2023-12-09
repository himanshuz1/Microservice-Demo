package com.employeeservice.example.controller;

import com.employeeservice.example.feign.DepartmentFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    private final DepartmentFeignClient departmentFeignClient;

    @GetMapping("{name}")
    public ResponseEntity<Object> testWebClientCall(@PathVariable("name") String name) {
       // String response = webClient.get().uri("http://localhost:2000/api/v1/himanshu/test").retrieve().bodyToMono(String.class).block();
        ResponseEntity<String> responseEntity = departmentFeignClient.testDepartment(name);
        log.debug("responseEntity from department service==={}", responseEntity);
        return ResponseEntity.ok("response from department service in emp service===" + responseEntity + "__________" + name);
    }
}
