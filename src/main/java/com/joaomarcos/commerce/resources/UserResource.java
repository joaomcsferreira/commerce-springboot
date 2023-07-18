package com.joaomarcos.commerce.resources;

import com.joaomarcos.commerce.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Diovana", "diovana@example.com", "+55 (99) 99999-9999", "12345678");

        return ResponseEntity.ok().body(user);
    }
}
