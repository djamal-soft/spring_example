package com.example.stock.controllers;

import com.example.stock.dao.StockProductsDao;
import com.example.stock.models.StockProducts;
import com.example.stock.proxies.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StockProductController {

    @Autowired
    private ProductProxy productProxy;

    @Autowired
    private StockProductsDao stockProductsDao;

    @GetMapping(value = "stock-products/{stockId}")
    public List getStockProducts(@PathVariable("stockId") int stockId) {
        List<StockProducts> sProducts = stockProductsDao.findByStockId(stockId);
        List<Integer> products = new ArrayList<>();
        for(StockProducts sp : sProducts) {
            products.add(sp.getProductId());
        }

        return productProxy.stockProducts(products);
    }

    @GetMapping(value = "stock-products/{stockId}/{productId}")
    public StockProducts getStockProduct(
            @PathVariable("stockId") int stockId,
            @PathVariable("productId") int productId
    ) {

        return stockProductsDao.findByStockIdAndProductId(
                stockId,
                productId
        );
    }

    @PostMapping(value = "stock-products")
    public StockProducts addProductToStock(@RequestBody StockProducts stockProduct) {

        return stockProductsDao.save(stockProduct);
    }

    @PutMapping(value = "stock-products/add")
    public StockProducts addProductQuantityInStock(
            @RequestBody StockProducts stockProductRequest) {

        StockProducts stockProduct = stockProductsDao.findByStockIdAndProductId(
                stockProductRequest.getStockId(),
                stockProductRequest.getProductId()
        );

        int oldQuantity = stockProduct.getQuantity();
        int newQuantity = oldQuantity + stockProductRequest.getQuantity();
        stockProduct.setQuantity(newQuantity);

        return stockProductsDao.save(stockProduct);
    }

    @PutMapping(value = "stock-products/delete")
    public StockProducts deleteProductQuantityInStock(
            @RequestBody StockProducts stockProductRequest) {

        StockProducts stockProduct = stockProductsDao.findByStockIdAndProductId(
                stockProductRequest.getStockId(),
                stockProductRequest.getProductId()
        );

        int oldQuantity = stockProduct.getQuantity();
        int newQuantity = oldQuantity - stockProductRequest.getQuantity();
        stockProduct.setQuantity(newQuantity);

        return stockProductsDao.save(stockProduct);
    }
}
