package com.joaomarcos.commerce.services;

import com.joaomarcos.commerce.repositories.UserRepository;
import com.joaomarcos.commerce.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);

        return user.get();
    }

    public User insert(User user) {
        return repository.save(user);
    }
}
