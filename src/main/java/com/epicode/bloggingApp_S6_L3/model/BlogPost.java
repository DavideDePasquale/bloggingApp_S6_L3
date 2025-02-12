package com.epicode.bloggingApp_S6_L3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity(name = "blogposts")
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private Integer tempoDiLettura;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Autore autore;

}
