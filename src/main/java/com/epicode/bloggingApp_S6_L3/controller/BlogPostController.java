package com.epicode.bloggingApp_S6_L3.controller;

import com.epicode.bloggingApp_S6_L3.DTO.BlogPostDTO;
import com.epicode.bloggingApp_S6_L3.model.BlogPost;
import com.epicode.bloggingApp_S6_L3.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogPostController {

    @Autowired
    Services services;

    @PostMapping("/blogpost")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPostDTO createBlogPost(@RequestBody BlogPostDTO blogPostDTO){

       if(blogPostDTO.getTitolo() == null) {
         throw new RuntimeException("Non è possibile creare un post senza titolo⚠️");
       }
       return services.createBlogPost(blogPostDTO);
    }
}
