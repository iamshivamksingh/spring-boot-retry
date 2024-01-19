package com.example.demo.configuration.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

/**
 * @author sksingh created on 18/01/24
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ConfigProperty {

    private String id;
    private String oem;
    private String program;
    private String dealerId;
    private String tenantId;
    //    @JsonDeserialize(using = WorkflowConfigDeserializer.class)
    private Map<String, Workflow> workflowConfig;
    //    @JsonDeserialize(using = MetadataDeserializer.class)
    private Map<String, Object> metadata;
}
