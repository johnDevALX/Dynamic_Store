package com.ekene.store.controllers;

import com.ekene.store.enumerations.Gender;
import com.ekene.store.enumerations.Role;
import com.ekene.store.models.Applicant;
import com.ekene.store.models.CreateID;
import com.ekene.store.serviceImplementations.ManagerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "cashierHireControllerServlet", value = "/cashierHireControllerServlet")
public class cashierHireControllerServlet extends HttpServlet {
    private ManagerService managerService = new ManagerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/cashierRegister.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Gender gender = Gender.valueOf(request.getParameter("gender"));
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        Role role = Role.valueOf(request.getParameter("role"));
        int yearsOfExp = Integer.parseInt(request.getParameter("yearsOfExp"));

        Applicant applicant = new Applicant();
        CreateID createID = new CreateID();
        int numId = createID.createNum();

        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setGender(gender);
        applicant.setAge(age);
        applicant.setEmail(email);
        applicant.setRoleAppliedFor(role);
        applicant.setYearsOfExperience(yearsOfExp);

        managerService.hireACashier(applicant, numId);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/successfulMsg.jsp");
        requestDispatcher.forward(request, response);
    }
}
