package com.ekene.store.controllers;

import com.ekene.store.models.Product;
import com.ekene.store.serviceImplementations.CustomerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "searchProductCtrl", value = "/searchProductCtrl")
public class searchProductCtrl extends HttpServlet {
    CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Product product = customerService.findProduct(name);

        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/foundProduct.jsp");
        requestDispatcher.forward(request, response);
    }

}
