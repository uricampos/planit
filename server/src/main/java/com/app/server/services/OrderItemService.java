package com.app.server.services;

import com.app.server.entities.OrderItem;
import com.app.server.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> saveAll(List<OrderItem> items) {
        return orderItemRepository.saveAll(items);
    }
}
