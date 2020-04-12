package com.example.stock.dao;

import com.example.stock.models.StockProductId;
import com.example.stock.models.StockProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Max;
import java.util.List;

public interface StockProductsDao extends JpaRepository<StockProducts, StockProductId> {

    //@Query("SELECT stock_id, products_id, quantity FROM stock_products WHERE stock_id = :stockId")
    List<StockProducts> findByStockId(int stockId);
    StockProducts findByStockIdAndProductId(int stockId, int productId);
}
