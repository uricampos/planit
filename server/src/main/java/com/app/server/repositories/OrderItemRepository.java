package com.app.server.repositories;

import com.app.server.entities.OrderItem;
import com.app.server.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
