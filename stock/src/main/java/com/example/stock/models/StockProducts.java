package com.example.stock.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "stock_products")
@IdClass(StockProductId.class)
public class StockProducts implements Serializable {

    @Id
    @Column(name = "product_id")
    private int productId;

    @Id
    @Column(name = "stock_id")
    private int stockId;

    private int quantity;

    public StockProducts() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StockProducts{" +
                "productId=" + productId +
                ", stockId=" + stockId +
                ", quantity=" + quantity +
                '}';
    }
}

