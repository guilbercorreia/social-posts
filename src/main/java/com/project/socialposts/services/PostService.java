package com.project.socialposts.services;

import java.util.List;

import com.project.socialposts.domain.model.Post;

public interface PostService {

    Post addPost(Long id, Post post);
    List<Post> findAll();
    Post findById(Long id);
    void deletePost(Long postID,Long userId);
}
