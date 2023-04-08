package com.ekene.store.dao;

import com.ekene.store.configuration.ConnectionConfig;
import com.ekene.store.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProductDao {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao.findProduct("phone");
    }
    public void createProduct(Product product){
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement pr = connection.prepareStatement("INSERT INTO products(name, price, quantity) VALUES(?, ?, ?)")){
            pr.setString(1, product.getProductName());
            pr.setBigDecimal(2, product.getPrice());
            pr.setInt(3, product.getQuantity());
            pr.executeUpdate();

            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> displayProduct(){
        List<Product> productList = new ArrayList<>();
        Product product = null;
        try(Connection connection = ConnectionConfig.getConnection();
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM products");
            ResultSet resultSet = pr.executeQuery();){
            while (resultSet.next()){
                product = new Product();
                product.setProductId(resultSet.getInt(1));
                product.setProductName(resultSet.getString(2));
                product.setPrice(resultSet.getBigDecimal(3));
                product.setQuantity(resultSet.getInt(4));
                productList.add(product);
                System.out.println(product.getProductId() + product.getProductName() + product.getPrice() + product.getQuantity());
            }
            productList.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public Product findProduct(String productName){
        Product product = new Product();
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE name = ?");
             ){
            preparedStatement.setString(1, productName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product.setProductId(resultSet.getInt(1));
                product.setProductName(resultSet.getString(2));
                product.setPrice(resultSet.getBigDecimal(3));
                product.setQuantity(resultSet.getInt(4));
                System.out.println(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
