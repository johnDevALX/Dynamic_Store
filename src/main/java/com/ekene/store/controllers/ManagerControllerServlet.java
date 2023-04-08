package com.ekene.store.controllers;

import com.ekene.store.dao.ManagerDao;
import com.ekene.store.enumerations.Gender;
import com.ekene.store.enumerations.Role;
import com.ekene.store.models.Manager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ManagerControllerServlet", value = "/ManagerControllerServlet")
public class ManagerControllerServlet extends HttpServlet {
    private ManagerDao managerDao = new ManagerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/managerRegister.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Gender gender = Gender.valueOf(request.getParameter("gender"));
        String email = request.getParameter("email");
        int salary = Integer.parseInt(request.getParameter("salary"));
        Role role = Role.valueOf(request.getParameter("role"));
        int id = Integer.parseInt(request.getParameter("id"));

        Manager manager = new Manager();
        manager.setFirstName(firstName);
        manager.setLastName(lastName);
        manager.setGender(gender);
        manager.setEmail(email);
        manager.setSalary(salary);
        manager.setRole(role);
        manager.setId(id);

        try {
            managerDao.registerManager(manager);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/managerDetails.jsp");
        requestDispatcher.forward(request, response);
    }
}
