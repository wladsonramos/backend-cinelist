package com.wladsonramos.cinelist.controllers;

import com.wladsonramos.cinelist.domain.film.Film;
import com.wladsonramos.cinelist.domain.film.FilmRepository;
import com.wladsonramos.cinelist.domain.film.RequestFilm;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

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

    @PutMapping
    @Transactional
    public ResponseEntity updateFilm(@RequestBody @Valid RequestFilm data) {
        Optional<Film> optionalFilm = repository.findById(data.id());
        if (optionalFilm.isPresent()) {
            Film film = optionalFilm.get();
            film.setName(data.name());
            film.setGenre(data.genre());
            film.setDescription(data.description());
            film.setWatchedDate(data.watchedDate());
            return ResponseEntity.ok(film);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFilm(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
