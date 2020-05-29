package com.example.springbootmysqldemo.repository;

import com.example.springbootmysqldemo.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    Product findByName(String name);

}
