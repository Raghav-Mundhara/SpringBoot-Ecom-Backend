package com.ecom.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.demo.model.Order;
import com.ecom.demo.model.OrderItem;
import com.ecom.demo.model.Product;
import com.ecom.demo.model.dto.OrderItemRequest;
import com.ecom.demo.model.dto.OrderItemResponse;
import com.ecom.demo.model.dto.OrderRequest;
import com.ecom.demo.model.dto.OrderResponse;
import com.ecom.demo.repo.OrderRepo;
import com.ecom.demo.repo.ProductRepo;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductRepo productRepo;

    public OrderResponse placeOrder(OrderRequest request) {
        Order order = new Order();
        String orderId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        order.setOrderId(orderId);
        order.setCustomerName(request.customerName());
        order.setEmail(request.email());
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now());

        List<OrderItem> orderItems = new ArrayList<>();
        for(OrderItemRequest itemRequest : request.items()){
            Product product = productRepo.findById(itemRequest.productId()).orElseThrow(()-> new RuntimeException("Product not found"));
            product.setStockQuantity(product.getStockQuantity()-itemRequest.quantity());
            productRepo.save(product);

            OrderItem orderItem = OrderItem.builder()
                                    .product(product)
                                    .quantity(itemRequest.quantity())
                                    .totalPrice(product.getPrice().multiply(BigDecimal.valueOf(itemRequest.quantity())))
                                    .order(order)
                                    .build();
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        Order savedOrder= orderRepo.save(order);

        List<OrderItemResponse> items = new ArrayList<>();
        for(OrderItem item : order.getOrderItems()){
            OrderItemResponse orderItemResponse = new OrderItemResponse(
                item.getProduct().getName(),
                item.getQuantity(),
                item.getTotalPrice()
            );
            items.add(orderItemResponse);
        }

        OrderResponse orderResponse = new OrderResponse(
            savedOrder.getOrderId(),
            savedOrder.getCustomerName(),
            savedOrder.getEmail(),
            savedOrder.getStatus(),
            savedOrder.getOrderDate(),
            items
        );
        return orderResponse;
    }

    public List<OrderResponse> getOrders() {
        return null;
    }

}
