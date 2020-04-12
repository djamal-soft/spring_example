package com.example.stock.proxies;

import com.example.stock.config.MyConfig;
import com.example.stock.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductProxy {

    public List stockProducts(List<Integer> productsIDs) {

        List products = new RestTemplate().postForObject(
                MyConfig.BASE_PRODUCT_MS_URL + "/products/search",
                productsIDs,
                List.class
                );

        return products;
    }
}
