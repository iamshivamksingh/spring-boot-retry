package com.example.demo.service;

import com.example.demo.model.Movie;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author sksingh created on 01/02/24
 */
@Service
public class MovieServiceImpl implements MovieService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Value("classpath:movies.json")
    private Resource movieFile;

    @Override
    public List<Movie> loadMovies() throws IOException {

        return MAPPER.readValue(
                movieFile.getInputStream(),
                new TypeReference<>() {
                }
        );
    }
}
