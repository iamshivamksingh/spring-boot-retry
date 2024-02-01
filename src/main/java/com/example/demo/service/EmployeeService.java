package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;

/**
 * @author sksingh created on 01/02/24
 */
public interface EmployeeService {

    EmployeeDTO save(Employee employee);
}
