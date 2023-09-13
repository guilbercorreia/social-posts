package com.project.socialposts.services;

import com.project.socialposts.domain.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    List<User> findAll();
    User insert(User userToCreate);
    void deleteById(Long id);
    User update(Long id, User userToUpdate);
}
