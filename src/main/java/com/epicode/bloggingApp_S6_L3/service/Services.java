package com.epicode.bloggingApp_S6_L3.service;

import com.epicode.bloggingApp_S6_L3.DTO.AutoreDTO;
import com.epicode.bloggingApp_S6_L3.DTO.BlogPostDTO;
import com.epicode.bloggingApp_S6_L3.mapper.AutoreMapperDTO;
import com.epicode.bloggingApp_S6_L3.mapper.BlogPostMapperDTO;
import com.epicode.bloggingApp_S6_L3.model.Autore;
import com.epicode.bloggingApp_S6_L3.model.BlogPost;
import com.epicode.bloggingApp_S6_L3.repository.AutoreRepository;
import com.epicode.bloggingApp_S6_L3.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class Services {
    @Autowired
    AutoreRepository autoreRepository;
    @Autowired
    BlogPostRepository blogPostRepository;
    @Autowired
    BlogPostMapperDTO blogPostMapperDTO;
    @Autowired
    AutoreMapperDTO autoreMapperDTO;




    public Page<BlogPostDTO> getAllBlog(Pageable pageable){
        return blogPostRepository.findAll(pageable).map(BlogPostMapperDTO ::toDTO);
    }


    public BlogPostDTO createBlogPost(BlogPostDTO blogPostDto){
     BlogPost bg = blogPostMapperDTO.toEntity(blogPostDto);
     blogPostRepository.save(bg);
     return blogPostDto;
    }

    public AutoreDTO createAutore(AutoreDTO autoreDTO){
        Autore autore = autoreMapperDTO.toEntity(autoreDTO);
        autoreRepository.save(autore);
        return autoreDTO;
    }


}
