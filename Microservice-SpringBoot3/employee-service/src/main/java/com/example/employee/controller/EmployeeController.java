package com.example.employee.controller;

import com.example.employee.openfeign.DepartmentFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
@RestController
public class EmployeeController {

    //private final WebClient webClient;

    private final DepartmentFeignClient departmentFeignClient;

    private final RestTemplate restTemplate;

    private final WebClient.Builder loadBalancedWebClientBuilder;

    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartmentResponse")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartmentResponse")
    @GetMapping("{name}")
    public ResponseEntity<Object> testWebClientCall(@PathVariable("name") String name) {
        //String response = webClient.get().uri("http://localhost:2000/api/v1/himanshu/test").retrieve().bodyToMono(String.class).block();

        //String response = webClient.get().uri("http://DEPARTMENT-SERVICE/api/v1/himanshu/test").retrieve().bodyToMono(String.class).block();
       /* HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange("http://DEPARTMENT-SERVICE/api/v1/himanshu/test",HttpMethod.GET,httpEntity, String.class);*/
                //departmentFeignClient.testDepartment(name);
        String response = loadBalancedWebClientBuilder.build().get().uri("http://DEPARTMENT-SERVICE/api/v1/himanshu/test").retrieve().bodyToMono(String.class).block();

        log.debug("responseEntity from department service==={}", response);
        return ResponseEntity.ok("response from department service in emp service===" + response + "__________" + name);
    }

    public ResponseEntity<String> getDefaultDepartmentResponse(Exception exception) {
        exception.printStackTrace();
        return ResponseEntity.ok("Default Response Department");
    }

}
