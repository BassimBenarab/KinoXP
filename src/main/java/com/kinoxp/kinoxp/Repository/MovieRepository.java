package com.kinoxp.kinoxp.Repository;

import com.kinoxp.kinoxp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}