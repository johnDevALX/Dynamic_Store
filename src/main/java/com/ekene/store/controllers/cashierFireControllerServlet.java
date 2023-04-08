package com.ekene.store.controllers;

import com.ekene.store.models.Cashier;
import com.ekene.store.serviceImplementations.ManagerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "cashierFireControllerServlet", value = "/cashierFireControllerServlet")
public class cashierFireControllerServlet extends HttpServlet {
    private ManagerService managerService = new ManagerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/cashierFire.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));

        Cashier cashier = new Cashier();
        cashier.setFirstName(firstName);
        String name = cashier.getFirstName();
        managerService.fireACashier(name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/successfulMsg.jsp");
        requestDispatcher.forward(request, response);
    }
}
