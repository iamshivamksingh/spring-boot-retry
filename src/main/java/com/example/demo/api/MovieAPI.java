package com.example.demo.api;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author sksingh created on 01/02/24
 */
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MovieAPI {

    private final MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> loadMovies() throws IOException {
        return ResponseEntity.ok(movieService.loadMovies());
    }
}
