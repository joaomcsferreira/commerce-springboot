package com.joaomarcos.commerce.repositories;

import com.joaomarcos.commerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
