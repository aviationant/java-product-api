package com.testapi.product_price_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public void addProduct(@RequestBody ProductRequest request) {
        productService.addProduct(request.getName(), request.getPrice());
    }

    @GetMapping("/average")
    public double getAveragePrice() {
        return productService.getAveragePrice();
    }

    @GetMapping("/item-price")
    public double getItemPrice(@RequestBody ProductRequest request) {
        return productService.getItemPrice(request.getName());
    }
}

class ProductRequest {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}