package com.example.orderservice.entity;

import java.time.Instant;

import javax.persistence.*;

@Entity
@Table(name = "tb_tr_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private int quantity;
    private long amount;
    private String status;
    private Instant date;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
