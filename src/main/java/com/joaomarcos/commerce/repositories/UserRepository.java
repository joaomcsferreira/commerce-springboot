package com.joaomarcos.commerce.repositories;

import com.joaomarcos.commerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
