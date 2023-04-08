package com.ekene.store.serviceImplementations;

import com.ekene.store.dao.ProductDao;
import com.ekene.store.models.Product;

public class CustomerService {
    ProductDao productDao = new ProductDao();

    public Product findProduct(String productName){
        return productDao.findProduct(productName);
    }
}
