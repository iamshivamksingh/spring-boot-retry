package com.example.demo.api;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author sksingh created on 01/02/24
 */
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class EmployeeAPI {

    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody Employee employee) {
        return ok(employeeService.save(employee));
    }
}
