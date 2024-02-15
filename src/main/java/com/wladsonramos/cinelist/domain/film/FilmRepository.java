package com.wladsonramos.cinelist.domain.film;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository <Film, String> {
}
