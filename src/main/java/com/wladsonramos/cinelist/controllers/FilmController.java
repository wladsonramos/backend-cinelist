package com.wladsonramos.cinelist.controllers;

import com.wladsonramos.cinelist.domain.film.Film;
import com.wladsonramos.cinelist.domain.film.FilmRepository;
import com.wladsonramos.cinelist.domain.film.RequestFilm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity registerFilm(@RequestBody @Valid RequestFilm data){
        Film newFilm = new Film(data);
        repository.save(newFilm);
        return ResponseEntity.ok().build();
    }
}
