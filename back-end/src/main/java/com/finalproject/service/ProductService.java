package com.finalproject.service;

import com.finalproject.models.Product;

import java.util.List;

public interface ProductService {
    void save(Product p);

    List<Product> findAll();
}
