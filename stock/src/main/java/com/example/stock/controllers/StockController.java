package com.example.stock.controllers;

import com.example.stock.dao.StockDao;
import com.example.stock.dao.StockProductsDao;
import com.example.stock.models.Stock;
import com.example.stock.models.StockProducts;
import com.example.stock.proxies.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockDao dao;

    @GetMapping(value = "stocks")
    public List<Stock> stocks() {

        return dao.findAll();
    }

    @GetMapping(value = "stocks/{id}")
    public Stock getStock(@PathVariable("id") int id) {

        return dao.findById(id);
    }

    @PostMapping(value = "stocks")
    public Stock addStock(@RequestBody Stock stock) {

        return dao.save(stock);
    }

    @DeleteMapping(value = "stocks/{id}")
    public void deleteStock(@PathVariable("id") int id) {

        dao.deleteById(id);
    }
}
