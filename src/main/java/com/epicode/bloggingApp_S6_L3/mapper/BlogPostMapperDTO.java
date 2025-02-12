package com.epicode.bloggingApp_S6_L3.mapper;

import com.epicode.bloggingApp_S6_L3.DTO.BlogPostDTO;
import com.epicode.bloggingApp_S6_L3.model.BlogPost;
import org.springframework.stereotype.Component;

@Component
public class BlogPostMapperDTO {

    public static BlogPostDTO toDTO(BlogPost blogPost){
        BlogPostDTO blogPostDTO = new BlogPostDTO();
        blogPostDTO.setTitolo(blogPost.getTitolo());
        blogPostDTO.setContenuto(blogPost.getContenuto());
        blogPostDTO.setCategoria(blogPost.getCategoria());
        blogPostDTO.setTempoDiLettura(blogPost.getTempoDiLettura());
        blogPostDTO.setAutore(blogPost.getAutore());
                return blogPostDTO;
    }

    public static BlogPost toEntity(BlogPostDTO blogPostDTO){
        BlogPost blogPost = new BlogPost();
        blogPost.setTitolo(blogPostDTO.getTitolo());
        blogPost.setContenuto(blogPostDTO.getContenuto());
        blogPost.setCategoria(blogPostDTO.getCategoria());
        blogPost.setTempoDiLettura(blogPostDTO.getTempoDiLettura());
        blogPost.setAutore(blogPostDTO.getAutore());
               return blogPost;

    }
}
