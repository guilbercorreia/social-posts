package com.project.socialposts.controllers;

import com.project.socialposts.domain.model.Post;
import com.project.socialposts.services.Impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok().body(postService.findAll());
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Post> addPost(@PathVariable Long id,@RequestBody Post post){
        postService.addPost(id, post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/posts/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}/user/{user}")
    public void removePost(@PathVariable Long id, @PathVariable Long user){
        postService.deletePost(id, user);
    }
}
