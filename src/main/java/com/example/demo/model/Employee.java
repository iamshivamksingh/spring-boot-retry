package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author sksingh created on 01/02/24
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

    private String name;
    private Address address;
    private BigDecimal salary;
}
