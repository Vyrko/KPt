package com.example.KP.controller;

import com.example.KP.entity.Book;
import com.example.KP.entity.User;
import com.example.KP.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/registration")
    public String registration(Model model){
        return "registration";
    }
    @GetMapping("/sing")
    public String sing(Model model){
        return "singUser";
    }
    @GetMapping("/registration/clear")
    public String clearForm(Model model){
        return "redirect:/registration";
    }
    @PostMapping("/registration")
    public String createUser(User user) throws IOException {
        userService.saveUser(user);
        return "redirect:/home";
    }
}
