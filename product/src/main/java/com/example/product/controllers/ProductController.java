package com.example.product.controllers;

import com.example.product.dao.CategoryDao;
import com.example.product.dao.ProductDao;
import com.example.product.models.Category;
import com.example.product.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @GetMapping(value = "products")
    public List<Product> allProducts() {

        return productDao.findAll();
    }

    @GetMapping(value = "products/{id}")
    public Product getProducts(@PathVariable("id") int id) {

        return productDao.findById(id);
    }

    @PostMapping(value = "products")
    public Product addProducts(@RequestBody Product product) {

         return productDao.save(product);
    }

    @PutMapping(value = "products")
    public void updateProducts(@RequestBody Product product) {

        productDao.save(product);
    }
}
