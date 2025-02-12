package com.epicode.bloggingApp_S6_L3.DTO;

import com.epicode.bloggingApp_S6_L3.model.Autore;
import lombok.Data;

@Data
public class BlogPostDTO {

    private String categoria;
    private String titolo;
    private String contenuto;
    private Integer tempoDiLettura;
    private Autore autore;

}
