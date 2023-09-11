package com.example.orderservice.service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.model.OrderRequest;
import com.example.orderservice.model.OrderResponse;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderResponse> getAll() {
        return orderRepository.findAll()
                .stream()
                .map(order -> {
                    OrderResponse orderResponse = new OrderResponse();
                    orderResponse.setId(order.getId());
                    orderResponse.setQuantity(order.getQuantity());
                    orderResponse.setAmount(order.getAmount());
                    orderResponse.setStatus(order.getStatus());
                    orderResponse.setDate(order.getDate());

                    return orderResponse;
                }).collect(Collectors.toList());
    }

    @Override
    public OrderResponse getById(long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Order with given id " + id + " not found"
                ));
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setQuantity(order.getQuantity());
        orderResponse.setAmount(order.getAmount());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setDate(order.getDate());

        return orderResponse;
    }

    @Override
    public OrderResponse create(OrderRequest orderRequest) {
        Order order = new Order();
        order.setQuantity(orderRequest.getQuantity());
        order.setAmount(orderRequest.getAmount());
        order.setStatus(orderRequest.getStatus());
        order.setDate(orderRequest.getDate());

        Order data = orderRepository.save(order);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(data.getId());
        orderResponse.setQuantity(data.getQuantity());
        orderResponse.setAmount(data.getAmount());
        orderResponse.setStatus(data.getStatus());
        orderResponse.setDate(data.getDate());

        return orderResponse;
    }

    @Override
    public OrderResponse update(long id, OrderRequest orderRequest) {
        getById(id);

        Order order = new Order();
        order.setId(id);
        order.setQuantity(orderRequest.getQuantity());
        order.setAmount(orderRequest.getAmount());
        order.setStatus(orderRequest.getStatus());
        order.setDate(orderRequest.getDate());

        Order data = orderRepository.save(order);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(data.getId());
        orderResponse.setQuantity(data.getQuantity());
        orderResponse.setAmount(data.getAmount());
        orderResponse.setStatus(data.getStatus());
        orderResponse.setDate(data.getDate());

        return orderResponse;
    }

    @Override
    public OrderResponse delete(long id) {
        OrderResponse orderResponse = getById(id);
        orderRepository.deleteById(id);
        return orderResponse;
    }
}
