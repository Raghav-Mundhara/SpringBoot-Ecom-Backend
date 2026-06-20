package com.ecom.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.demo.model.dto.OrderRequest;
import com.ecom.demo.model.dto.OrderResponse;
import com.ecom.demo.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @PostMapping("/placeorder")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(orderResponse,HttpStatus.OK);
    }

    @GetMapping("/getOrders")
    public ResponseEntity<List<OrderResponse>> getOrders() {
        List<OrderResponse> orderResponses = orderService.getOrders();
        return new ResponseEntity<List<OrderResponse>>(orderResponses,HttpStatus.OK);
    }
    
}
