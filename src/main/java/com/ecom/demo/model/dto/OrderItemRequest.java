package com.ecom.demo.model.dto;

public record OrderItemRequest(
    int productId,
    int quantity
) {}
