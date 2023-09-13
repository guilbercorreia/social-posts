package com.project.socialposts.services;

import com.project.socialposts.domain.model.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {

    Post addPost(Post post);
    List<Post> findAll();
    void deletePost(Long id);

}
