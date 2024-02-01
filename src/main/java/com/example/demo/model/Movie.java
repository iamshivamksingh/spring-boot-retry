package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author sksingh created on 01/02/24
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    private String title;
    private String year;
    private String director;
    private String actors;

    // This should be list of strings. Currently kept as string to test exception mapper
    // See ExceptionMapper.class for implementation
    private String images;
}
