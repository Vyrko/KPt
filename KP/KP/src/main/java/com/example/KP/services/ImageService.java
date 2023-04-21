package com.example.KP.services;
import com.example.KP.entity.Image;
import com.example.KP.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public  Iterable<Image>  readImg()
    {
        Iterable<Image> images = imageRepository.findAll();
        return  images;
    }
}