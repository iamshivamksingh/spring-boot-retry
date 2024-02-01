package com.example.demo.api;

import com.example.demo.configuration.ConfigLoader;
import com.example.demo.bean.ConfigProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

/**
 * @author sksingh created on 01/02/24
 */
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ConfigAPI {

    private final ConfigLoader configLoader;

    @GetMapping("/configs")
    public ResponseEntity<Map<String, ConfigProperty>> getConfigs() throws IOException {
        return ResponseEntity.ok(configLoader.configPropertyMap());
    }
}
