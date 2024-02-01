package com.example.demo.configuration;

import com.example.demo.bean.ConfigProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sksingh created on 18/01/24
 */
@Configuration
public class ConfigLoader {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Value("classpath:config_property.json")
    private Resource configFile;

    @Bean
    public Map<String, ConfigProperty> configPropertyMap() throws IOException {
        List<ConfigProperty> workflowList = MAPPER.readValue(
                configFile.getInputStream(),
                new TypeReference<>() {
                }
        );

        Map<String, ConfigProperty> workflowMap = new HashMap<>();
        for (ConfigProperty configProperty : workflowList) {
            workflowMap.put(configProperty.getId(), configProperty);
        }

        return workflowMap;
    }
}
