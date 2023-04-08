package com.ekene.store.controllers;

import com.ekene.store.models.Product;
import com.ekene.store.serviceImplementations.ManagerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "displayProductCtrl", value = "/displayProductCtrl")
public class displayProductCtrl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManagerService managerService = new ManagerService();
        List<Product> productList = managerService.printAllProduct();


        request.setAttribute("product", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/displayAllProduct.jsp");
        requestDispatcher.forward(request, response);
        for (Product product: productList
             ) {
            System.out.println(product + " from servlet");
        }
    }
}
