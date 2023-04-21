package com.example.KP.services;

import com.example.KP.entity.Genre;
import com.example.KP.repository.BookRepository;
import com.example.KP.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenreService {
    private final GenreRepository genreRepository;

    public Iterable<Genre> readGenreByBookId(Long id) {
        return genreRepository.findAllByBookId(id);
    }
}