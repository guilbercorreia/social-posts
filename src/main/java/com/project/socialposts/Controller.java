package com.project.socialposts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.socialposts.domain.model.User;
import com.project.socialposts.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        var result = userService.findAll();
        return ResponseEntity.ok().body(result);
    }
    
}
