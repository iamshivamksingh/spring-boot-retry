package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.exception.NonRetryableException;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import static com.example.demo.util.RandomIdGenerator.getRandomId;

/**
 * @author sksingh created on 01/02/24
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int DEFAULT_ID_LEN = 8;

    @Override
    public EmployeeDTO save(Employee employee) {

        String randomId = getRandomId(DEFAULT_ID_LEN);

        if (randomId.contains("x")) {
            System.out.printf("EmployeeId: %s generated has x in it%n", randomId);
            throw new NonRetryableException();
        }

        return new EmployeeDTO().setId(randomId);
    }
}
