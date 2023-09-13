package com.project.socialposts.services.Impl;

import com.project.socialposts.domain.model.User;
import com.project.socialposts.domain.repositories.UserRepository;
import com.project.socialposts.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User insert(User userToCreate) {
        return userRepository.save(userToCreate);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(Long id,User userToUpdate) {
        var dbUser = userRepository.findById(id).get();
        dbUser.setEmail(userToUpdate.getEmail());
        dbUser.setName(userToUpdate.getName());
        return userRepository.save(dbUser);
    }
}
