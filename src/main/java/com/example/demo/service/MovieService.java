package com.example.demo.service;

import com.example.demo.model.Movie;

import java.io.IOException;
import java.util.List;

/**
 * @author sksingh created on 01/02/24
 */
public interface MovieService {

    List<Movie> loadMovies() throws IOException;
}
