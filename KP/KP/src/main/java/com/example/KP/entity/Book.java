package com.example.KP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cost;
    @OneToMany(cascade = CascadeType.REMOVE, fetch =FetchType.LAZY,mappedBy = "book")
    private List<Genre> genres= new ArrayList<>();
    private String author;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
    mappedBy = "book")
    private List<Image> images=new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dataOfCreated;
    @PrePersist
    private void init(){dataOfCreated=LocalDateTime.now();}
    public void addImageToBook(Image image){
        image.setBook(this);
        images.add(image);
    }
    public void setGenre(Genre genre){
        genre.setBook(this);
        genres.add(genre);
    }
}
