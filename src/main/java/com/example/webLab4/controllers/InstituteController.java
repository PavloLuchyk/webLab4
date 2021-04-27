package com.example.webLab4.controllers;

import com.example.webLab4.models.Faculty;
import com.example.webLab4.models.Institute;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "InstituteController", value = "/InstituteController")
public class InstituteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("institute", request.getSession().getAttribute(request.getParameter("institute")));
        request.getRequestDispatcher("/WEB-INF/jsp/institute.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Institute institute = (Institute) httpSession.getAttribute(request.getParameter("institute"));
        institute.addFaculty(new Faculty(request.getParameter("faculty_name")));
        request.setAttribute("institute", request.getSession().getAttribute(request.getParameter("institute")));
        request.getRequestDispatcher("/WEB-INF/jsp/institute.jsp").forward(request,response);
    }
}
