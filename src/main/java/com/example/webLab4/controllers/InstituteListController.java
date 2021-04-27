package com.example.webLab4.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.ArrayList;

import com.example.webLab4.models.Institute;

@WebServlet(name = "InstituteListController", value = "/InstituteListController")
public class InstituteListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/jsp/instituteList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processData(request, response);
    }

    private void processData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession servletContext = request.getSession();
        String name = request.getParameter("institute_name");
        servletContext.setAttribute(name, new Institute(name));
        request.getRequestDispatcher("WEB-INF/jsp/instituteList.jsp").forward(request,response);
    }

}
