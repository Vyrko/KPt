package com.example.KP.repository;

import com.example.KP.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    /*@Query("SELECT  gn from Genre gn " +
            "where gn.book.id = ?1")
    Iterable<Genre> findAllByBookId(Long id);*/
    Optional<Genre> findById(Long id);
}
