package com.example.KP.repository;

import com.example.KP.entity.Book;
import com.example.KP.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByName(String name);
    List<Book> findByAuthor(String author);
@Query("SELECT b FROM Book b " +
        "inner JOIN BooksGenres g ON g.bookId = b.id" +
        " where  g.genreId =?1")
    List<Book> findByGenres(Long genres);

}
