package com.ekene.store.controllers;

import com.ekene.store.serviceImplementations.ManagerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "managerLoginController", value = "/managerLoginController")
public class managerLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/managerLogin.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        int mgrId = Integer.parseInt(request.getParameter("mgrId"));
        ManagerService managerService = new ManagerService();
        if (managerService.mLogin(firstName, mgrId)){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/managerDetails.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/managerLogin.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
