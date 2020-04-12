package com.example.stock.dao;

import com.example.stock.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao extends JpaRepository<Stock, Integer> {

    Stock findById(int id);

    void deleteById(int id);
}
