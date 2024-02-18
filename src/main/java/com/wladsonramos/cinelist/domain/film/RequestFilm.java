package com.wladsonramos.cinelist.domain.film;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;

public record RequestFilm(String id, @NotBlank String name, @NotBlank String genre, @NotBlank String description, LocalDate watchedDate) {
}
