package com.epicode.bloggingApp_S6_L3.repository;

import com.epicode.bloggingApp_S6_L3.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {
}
