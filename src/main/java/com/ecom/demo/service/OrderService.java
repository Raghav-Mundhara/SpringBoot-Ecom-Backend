package com.ecom.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.demo.model.dto.OrderRequest;
import com.ecom.demo.model.dto.OrderResponse;
import com.ecom.demo.repo.OrderRepo;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        return null;

    }

    public List<OrderResponse> getOrders() {
        return orderRepo.findAll();
    }

}
