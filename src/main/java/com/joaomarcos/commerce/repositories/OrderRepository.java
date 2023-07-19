package com.joaomarcos.commerce.repositories;

import com.joaomarcos.commerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
