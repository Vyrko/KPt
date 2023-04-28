package com.example.KP.controller;

import com.example.KP.entity.Book;
import com.example.KP.entity.Genre;
import com.example.KP.entity.Image;
import com.example.KP.services.BookService;
import com.example.KP.services.GenreService;
import com.example.KP.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class MainHomeController {
    private final BookService bookService;
    private final ImageService imageService;
    private final GenreService genreService;
    @GetMapping
    public String open(Model model)
    {
        Iterable<Book> books = bookService.readBook();
        Iterable<Image> images = imageService.readImg();
        Iterable<Genre> genres =genreService.readAllGenre();
        model.addAttribute("genres", genres);
        model.addAttribute("book",books);
        model.addAttribute("image",images);
        return "mainHome";
    }
    @GetMapping("/search")
    public String searchBookByName(@RequestParam(name = "nameBook", required = false) String nameBook, Model model){
        Iterable<Book> books = bookService.listBooks(nameBook);
        Iterable<Image> images = imageService.readImg();
        model.addAttribute("book",books);
        model.addAttribute("image",images);
        return "mainHome";
    }
    @GetMapping("/filter")
    public String getBooksByGenres(@RequestParam("checkboxGenre") Long idGenre,
                                   Model model){
        Iterable<Book> books=bookService.AllBookByGenre(idGenre);
        Iterable<Image> images = imageService.readImg();
        model.addAttribute("book", books);
        model.addAttribute("image",images);
        return "mainHome";
    }
}
