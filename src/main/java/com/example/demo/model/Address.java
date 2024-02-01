package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author sksingh created on 01/02/24
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private String street;
    private String zipcode;
    private State state;


    public static class State {
        private String name;
        private String code;
    }
}
