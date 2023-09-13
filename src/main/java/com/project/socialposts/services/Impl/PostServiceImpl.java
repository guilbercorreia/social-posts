package com.project.socialposts.services.Impl;

import com.project.socialposts.domain.model.Post;
import com.project.socialposts.domain.repositories.PostRepository;
import com.project.socialposts.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
