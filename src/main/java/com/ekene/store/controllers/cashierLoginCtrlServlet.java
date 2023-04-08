package com.ekene.store.controllers;

import com.ekene.store.serviceImplementations.ManagerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "cashierLoginCtrlServlet", value = "/cashierLoginCtrlServlet")
public class cashierLoginCtrlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/cashierLogin.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("firstName");
        int id = Integer.parseInt(request.getParameter("employeeId"));
        try {
            if (ManagerService.cLogin(name, id)){
                request.setAttribute("Name", name);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/cashierDashboard.jsp");
                requestDispatcher.forward(request, response);
                System.out.println(name + " from servlet");
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/cashierLogin.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
//        try {
//            if ((managerService.cLogin(c.getFirstName(), c.getId()) != null )){
//                if (c.getFirstName().equalsIgnoreCase(name) && c.getId() == id){
//                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/cashierDashboard.jsp");
//                    requestDispatcher.forward(request, response);
//                } else {
//                    request.setAttribute("message", "Confirm Details And Try Again");
//                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/cashierLogin.jsp");
//                    requestDispatcher.forward(request, response);
//                }
//            } else {
//                request.setAttribute("message", "Cashier Details Not Found!!!");
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/cashierLogin.jsp");
//                requestDispatcher.forward(request, response);
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
