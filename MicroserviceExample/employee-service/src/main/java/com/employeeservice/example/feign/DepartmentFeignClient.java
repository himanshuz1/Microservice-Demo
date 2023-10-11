package com.employeeservice.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8081", name = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentFeignClient {
    @GetMapping("api/v1/{id-dep_id}/test")
    public ResponseEntity<String> testDepartment(@PathVariable("id-dep_id") String departmentId);
}
