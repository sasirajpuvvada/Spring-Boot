package com.example.springbootmysqldemo.service;

import com.example.springbootmysqldemo.model.Product;
import com.example.springbootmysqldemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public List<Product> showProducts(){
        return productRepository.findAll();
    }

    public Product showProduct(Integer id){
        return productRepository.findById(id).orElse(null);
    }

    public Product showProductByName(String name){
        return productRepository.findByName(name);
    }

    public String deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return  "Deleted";
    }


    public void updateProduct(Product product, int id) {
        Product existringProd = productRepository.findById(id).orElse(null);
        existringProd.setName(product.getName());
        existringProd.setPrice(product.getId());
        existringProd.setQuantity(product.getQuantity());
        productRepository.save(existringProd);
    }
}
