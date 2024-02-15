package com.wladsonramos.cinelist.controllers;

import com.wladsonramos.cinelist.domain.film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmRepository repository;
    @GetMapping
    public ResponseEntity getAllFilms(){
        var allFilms = repository.findAll();
        return ResponseEntity.ok(allFilms);
    }
}
