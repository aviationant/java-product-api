package com.testapi.product_price_service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(String name, double price) {
        Product product = new Product(name, price);
        productRepository.save(product);
    }

    public double getAveragePrice() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total / products.size();
    }

    public double getItemPrice(String name) {
        Optional<Product> product = productRepository.findByName(name);
        return product.map(Product::getPrice).orElse(0.0);
    }
}