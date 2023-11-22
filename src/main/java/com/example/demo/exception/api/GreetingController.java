package com.example.demo.exception.api;

import com.example.demo.exception.service.GreetingService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sksingh created on 21/11/23
 */
@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class GreetingController {


    private final GreetingService greetingService;


    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        try {
            return ResponseEntity.ok(this.greetingService.sayIt());
        } catch (RuntimeException e) {
           // TODO
        }
        return ResponseEntity.ok("Hello, World!");
    }

}
