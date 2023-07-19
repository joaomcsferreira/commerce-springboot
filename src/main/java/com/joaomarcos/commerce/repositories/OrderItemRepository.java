package com.joaomarcos.commerce.repositories;

import com.joaomarcos.commerce.entities.OrderItem;
import com.joaomarcos.commerce.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
