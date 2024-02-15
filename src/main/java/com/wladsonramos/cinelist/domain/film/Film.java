package com.wladsonramos.cinelist.domain.film;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Table(name="film")
@Entity(name="film")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Film {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String genre;

    private String description;

    private LocalDate watchedDate;

    public Film(RequestFilm requestFilm){
        this.name = requestFilm.name();
        this.genre = requestFilm.genre();
        this.description = requestFilm.description();
        this.watchedDate = requestFilm.watchedDate();
    }
}
