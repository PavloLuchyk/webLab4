package com.example.webLab4.controllers;

import com.example.webLab4.models.DataProcessor;
import com.example.webLab4.models.Institute;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TestFillController", value = "/TestFillController")
public class TestFillController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Institute institute = (Institute) request.getSession().getAttribute(request.getParameter("institute"));
        DataProcessor.testFill(institute);
        request.setAttribute("institute", institute);
        request.getRequestDispatcher("/WEB-INF/jsp/institute.jsp").forward(request,response);
    }
}
