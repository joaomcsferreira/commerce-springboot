package com.joaomarcos.commerce.services;

import com.joaomarcos.commerce.repositories.UserRepository;
import com.joaomarcos.commerce.entities.User;
import com.joaomarcos.commerce.services.exceptions.DatabaseException;
import com.joaomarcos.commerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        try {
            User updateUser = repository.getReferenceById(id);

            updateData(updateUser, user);

            return repository.save(updateUser);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User updateUser, User user) {
        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhone(user.getPhone());
    }
}
