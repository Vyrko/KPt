package com.example.KP.services;

import com.example.KP.entity.Book;
import com.example.KP.entity.Enum.Role;
import com.example.KP.entity.Image;
import com.example.KP.entity.User;
import com.example.KP.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean saveUser(User user) throws IOException {
        if (userRepository.findByEmail(user.getEmail()) !=null) return false;
        user.setActive(true);
        user.getRole().add(Role.ROLE_USER);
        user.setPassword(user.getPassword());
        log.info("Save new user email: {}", user.getEmail());
        userRepository.save(user);
        return true;
    }
    public boolean saveAdmin(User user){
        if (userRepository.findByEmail(user.getEmail()) !=null) return false;
        user.setActive(true);
        user.getRole().add(Role.ROLE_ADMIN);
        log.info("Save new user email: {}", user.getEmail());
        return true;
    }
}
