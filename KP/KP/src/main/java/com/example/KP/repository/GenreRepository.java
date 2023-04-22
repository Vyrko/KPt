package com.example.KP.repository;

import com.example.KP.entity.Book;
import com.example.KP.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    @Query("SELECT  gn from Genre gn " +
            "where gn.book.id = ?1")
    Iterable<Genre> findAllByBookId(Long id);

    Genre findByName(String name);
}
