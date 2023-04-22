package com.example.KP.controller;

import com.example.KP.entity.Book;
import com.example.KP.entity.Genre;
import com.example.KP.repository.BookRepository;
import com.example.KP.services.BookService;
import com.example.KP.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/adminHome")
public class AdminHomeController {
    private final GenreService genreService;
    private final BookService bookService;

    @GetMapping
    public String adminHome(Model model) {
        Iterable<Genre> genres =genreService.readAllGenre();
                model.addAttribute("genres", genres);
        return "adminHome";
    }

    @PostMapping("/book/create")
    public String createBook(@RequestParam("file1") MultipartFile file1,
                             @RequestParam("checkboxGenre") List<Long> idGenre,
                             Book book) throws IOException {
        bookService.saveBook(book, file1,genreService.readGenreById(idGenre));
        return "redirect:/adminHome";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/adminHome";
    }
}
