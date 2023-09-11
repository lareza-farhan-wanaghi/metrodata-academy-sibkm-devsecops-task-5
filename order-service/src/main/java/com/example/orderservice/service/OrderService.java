package com.example.orderservice.service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.model.OrderRequest;
import com.example.orderservice.model.OrderResponse;

import java.util.List;

public interface OrderService {

    List<OrderResponse> getAll();
    OrderResponse getById(long id);
    OrderResponse create(OrderRequest orderRequest);
    OrderResponse update(long id, OrderRequest orderRequest);
    OrderResponse delete(long id);

}
