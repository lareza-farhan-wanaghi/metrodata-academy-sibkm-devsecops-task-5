package com.example.orderservice.controller;

import com.example.orderservice.model.OrderRequest;
import com.example.orderservice.model.OrderResponse;
import com.example.orderservice.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAll(){
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getById(@PathVariable long id){
        return new ResponseEntity<>(orderService.getById(id),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody OrderRequest orderRequest){
        return new ResponseEntity<>(orderService.create(orderRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> update(@PathVariable long id, @RequestBody OrderRequest orderRequest){
        return new ResponseEntity<>(orderService.update(id,orderRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderResponse> delete (@PathVariable long id){
        return new ResponseEntity<>(orderService.delete(id),HttpStatus.OK);
    }

}
