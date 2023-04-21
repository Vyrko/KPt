package com.example.KP.controller;

import com.example.KP.entity.Book;
import com.example.KP.repository.BookRepository;
import com.example.KP.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/adminHome")
public class AdminHomeController {
    private final BookService bookService;
    @GetMapping
    public String adminHome(Model model){
        return "adminHome";
    }
    @PostMapping("/book/create")
    public String createBook(@RequestParam("file1") MultipartFile file1,
                             Book book) throws IOException {
        bookService.saveBook(book,file1);
        return "redirect:/adminHome";
    }
    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return "redirect:/home";
    }
}