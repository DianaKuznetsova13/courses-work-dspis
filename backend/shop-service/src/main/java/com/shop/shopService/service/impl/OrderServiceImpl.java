package com.shop.shopService.service.impl;

import com.shop.shopService.entity.models.Order;
import com.shop.shopService.repository.OrderRepository;
import com.shop.shopService.service.OrderService;
import com.shop.shopService.service.base.impl.BaseCRUDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseCRUDServiceImpl<Order, Long> implements OrderService {

    final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
        this.repository = repository;
    }


    @Override
    public Order create(Order item) {
        Long id = repository.saveAndFlush(item).getId();
        repository.clear();
        return findById(id);
    }
}
