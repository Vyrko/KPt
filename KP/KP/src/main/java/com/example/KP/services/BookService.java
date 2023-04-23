package com.example.KP.services;

import com.example.KP.entity.Book;
import com.example.KP.entity.Genre;
import com.example.KP.entity.Image;
import com.example.KP.repository.BookRepository;
import com.example.KP.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    public List<Book> AllBook(){
        return bookRepository.findAll();
    }
    public List<Book> listBooks(String name){
        if (name!=null) return bookRepository.findByName(name);
        return bookRepository.findAll();
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }
    public Iterable<Book> readBook()
    {
     Iterable<Book> books = bookRepository.findAll();
     return books;
    }
    public void saveBook(Book book, MultipartFile file, List<Genre> genres) throws IOException {
        Image image;
        if (file.getSize() !=0){
            image=toImageEntity(file);
            image.setPreviewImage(true);
            book.addImageToBook(image);
        }
        log.info("Saving new Book. Name {}", book.getName());
        book.setGenres(genres);
        Book bookFromDb=bookRepository.save(book);
        bookFromDb.setPreviewImageId(bookFromDb.getImages().get(0).getId());
        /*for(int i =0; i<genres.size(); i++)
        {
            Genre genre = genreRepository.findByName(genres.get(i).getName());
            bookFromDb.setGenre(genre);
        }*/
        bookRepository.save(bookFromDb);
    }
    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image=new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        Base64.Encoder encoder = Base64.getEncoder();
        String encoded = encoder.encodeToString(file.getBytes());
        image.setBytes(encoded);
        return image;
    }
}
