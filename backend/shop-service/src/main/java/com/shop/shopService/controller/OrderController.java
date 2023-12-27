package com.shop.shopService.controller;

import com.shop.shopService.entity.models.Order;
import com.shop.shopService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @MutationMapping
    public Order createOrder(@Argument Order order) {
        return orderService.create(order);
    }
}
