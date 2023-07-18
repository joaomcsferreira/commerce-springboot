package com.joaomarcos.commerce.Repositories;

import com.joaomarcos.commerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
