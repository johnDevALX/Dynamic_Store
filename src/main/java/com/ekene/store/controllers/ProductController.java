package com.ekene.store.controllers;

import com.ekene.store.models.Product;
import com.ekene.store.serviceImplementations.ManagerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/addProduct.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        ManagerService managerService = new ManagerService();

        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(new BigDecimal(price));
        product.setQuantity(Integer.parseInt(quantity));
        managerService.createProduct(product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/productCreated.jsp");
        requestDispatcher.forward(request, response);
    }
}
