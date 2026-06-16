package com.ecom.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.demo.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

} 
