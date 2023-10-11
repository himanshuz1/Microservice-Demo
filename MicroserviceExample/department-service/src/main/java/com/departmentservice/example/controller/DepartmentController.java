package com.departmentservice.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DepartmentController {

    @GetMapping("api/v1/{id-dep_id}/test")
    public ResponseEntity<String> testDepartment(@PathVariable("id-dep_id") String departmentId) {
        log.debug("inside testDepartment");
        return ResponseEntity.ok(departmentId+"_ Success=");
    }

}
