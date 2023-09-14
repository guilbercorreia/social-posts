package com.project.socialposts.services.Impl;

import com.project.socialposts.domain.model.Post;
import com.project.socialposts.domain.repositories.PostRepository;
import com.project.socialposts.domain.repositories.UserRepository;
import com.project.socialposts.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Post addPost(Long id,Post post) {
        userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        var user = userRepository.findById(id).get();
        post.setDate(Date.from(Instant.now()));
        user.getPost().add(post);
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId, Long userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));
        var post = postRepository.findById(postId).orElseThrow(() -> new NoSuchElementException("Post not found"));
        user.getPost().remove(post);
        postRepository.deleteById(postId);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Post not found"));
    }
}
