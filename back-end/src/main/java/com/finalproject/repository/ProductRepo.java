package com.finalproject.repository;

import com.finalproject.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    List<Product> findByUser_Id(Long id);
}
