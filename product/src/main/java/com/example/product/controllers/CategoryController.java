package com.example.product.controllers;

import com.example.product.dao.CategoryDao;
import com.example.product.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @GetMapping(value = "/categories")
    public List<Category> allCategories() {

        return categoryDao.findAll();
    }

    @GetMapping(value = "/categories/{id}")
    public Category getCategory(@PathVariable("id") int id) {

        return categoryDao.findById(id);
    }

    @PostMapping(value = "/categories")
    public void saveCategory(@RequestBody Category category) {

        categoryDao.save(category);
    }

    @PutMapping(value = "/categories")
    public void updateCategory(@RequestBody Category category) {

        categoryDao.save(category);
    }

    @DeleteMapping(value = "/categories/{id}")
    public void saveCategory(@PathVariable("id") int id) {

        Category category = categoryDao.findById(id);
        categoryDao.delete(category);
    }
}
