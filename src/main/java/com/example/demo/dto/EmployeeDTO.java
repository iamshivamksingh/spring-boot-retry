package com.example.demo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author sksingh created on 01/02/24
 */
@Data
@Accessors(chain = true)
public class EmployeeDTO {

    private String id;
}
