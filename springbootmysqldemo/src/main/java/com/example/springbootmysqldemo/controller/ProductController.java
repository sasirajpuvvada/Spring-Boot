package com.example.springbootmysqldemo.controller;

import com.example.springbootmysqldemo.model.Product;
import com.example.springbootmysqldemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return product;
    }

    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products) {
        productService.saveProducts(products);
        return products;
    }

    @GetMapping("/Products")
    public List<Product> getAllproducts(){
        return productService.showProducts();
    }

    @GetMapping("/Products/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.showProduct(id);
    }

    @DeleteMapping("/Products/{id}")
    public String addProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/Products/{name}")
    public Product getProductByName(@PathVariable String name){
        return productService.showProductByName(name);
    }

    @PutMapping("/Products/{id}")
    public void updateProduct(@PathVariable Product product,@PathVariable int id) {
        productService.updateProduct(product,id);
    }


}
