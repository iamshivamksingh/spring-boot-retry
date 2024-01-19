package com.example.demo.configuration.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @author sksingh created on 18/01/24
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WorkflowLevel {

    private Integer level;
    private List<String> tasks;
}
