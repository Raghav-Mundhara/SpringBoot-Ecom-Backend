package com.ecom.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.demo.model.Order;
import com.ecom.demo.model.dto.OrderResponse;

@Repository
public interface OrderRepo extends JpaRepository<OrderResponse,Integer> {

}
