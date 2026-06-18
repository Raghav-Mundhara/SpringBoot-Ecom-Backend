package com.ecom.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.demo.model.Product;
import com.ecom.demo.repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        Product product = productRepo.findById(id).orElse(null);
        return product;
    }

    public String deleteProduct(int id){
        productRepo.deleteById(id);
        return "Product Deleted Successfully";
    }

    public Product updateProduct(Product product){
        Product originalProduct = productRepo.findById(product.getId()).orElse(null);
        if(originalProduct != null){
            productRepo.save(product);
        }
        return product;
    }
}
