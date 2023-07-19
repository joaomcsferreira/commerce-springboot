package com.joaomarcos.commerce.repositories;

import com.joaomarcos.commerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespository extends JpaRepository<Category, Long> {
}
