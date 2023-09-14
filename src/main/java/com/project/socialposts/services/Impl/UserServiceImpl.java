package com.project.socialposts.services.Impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.socialposts.domain.model.User;
import com.project.socialposts.domain.repositories.UserRepository;
import com.project.socialposts.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User insert(User userToCreate) {
        var user = findById(userToCreate.getId());
        if(Objects.equals(user.getId(), userToCreate.getId())){
            throw new IllegalArgumentException("User already exist.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        userRepository.deleteById(id);
    }

    @Override
    public User update(Long id,User userToUpdate) {
        userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        var dbUser = userRepository.findById(id).get();
        dbUser.setEmail(userToUpdate.getEmail());
        dbUser.setName(userToUpdate.getName());
        return userRepository.save(dbUser);
    }
}
