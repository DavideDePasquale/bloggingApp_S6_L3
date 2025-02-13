package com.epicode.bloggingApp_S6_L3.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.epicode.bloggingApp_S6_L3.DTO.AutoreDTO;
import com.epicode.bloggingApp_S6_L3.DTO.BlogPostDTO;
import com.epicode.bloggingApp_S6_L3.model.Autore;
import com.epicode.bloggingApp_S6_L3.model.BlogPost;
import com.epicode.bloggingApp_S6_L3.service.AutoreService;
import com.epicode.bloggingApp_S6_L3.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlogPostController {

    @Autowired
    Services services;

    @Autowired
    AutoreService autoreService;

    @Autowired
    Cloudinary cloudinary;

    @PostMapping("/blogpost")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPostDTO createBlogPost(@RequestBody BlogPostDTO blogPostDTO){

       if(blogPostDTO.getTitolo() == null) {
         throw new RuntimeException("Non è possibile creare un post senza titolo⚠️");
       }
       return services.createBlogPost(blogPostDTO);
    }

    //prova col prof
//    @PostMapping("/new")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String nuovoAutore(@RequestBody Autore nuovoAutore){
//      Long idGenerato =  autoreService.nuovoAutore(nuovoAutore);
//      return "L'autore con id " + idGenerato + " è stato inserito correttamente";
//
//    }



    @GetMapping("/byId/{idAutore}")
    public ResponseEntity<Autore> ricercaById(@PathVariable Long idAutore){
       Optional<Autore> autoreRicercato = autoreService.ricercaAutoreId(idAutore);
       if (autoreRicercato.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }   else {
           return new ResponseEntity<>(autoreRicercato.get(),HttpStatus.OK);

       }

    }






    @PostMapping("/autore")
    @ResponseStatus(HttpStatus.CREATED)
    public AutoreDTO createAutore(@RequestBody AutoreDTO autoreDTO){
        if(autoreDTO.getNome() == null){
            throw new RuntimeException("Non è possibile creare un autore senza il nome⚠️");
        }
        return services.createAutore(autoreDTO); // funziona
    }


    // autore con avatar
    @PostMapping("/nuovoAutoreConAvatar")
    public AutoreDTO nuovoAutoreconAvatar(@RequestPart("avatarAutore")MultipartFile avatarAutore, @RequestPart @Validated AutoreDTO autoreDTO, BindingResult validazione){

        if(validazione.hasErrors()){
            String messaggioErr = "errore validazione \n";
            for (ObjectError errore : validazione.getAllErrors()){
                messaggioErr += errore.getDefaultMessage() + " \n";
            }
        }
        try {
            Map mappa = cloudinary.uploader().upload(avatarAutore.getBytes(), ObjectUtils.emptyMap());
            // Recupero l'invio
            String urlImage = (String) mappa.get("secure_url");
            autoreDTO.setAvatar(urlImage);
            Long idGenerato = autoreService.nuovoAutore(autoreDTO);
            return autoreDTO;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
