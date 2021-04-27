package com.example.webLab4.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

import com.example.webLab4.models.Adder;
import com.example.webLab4.models.Faculty;
import com.example.webLab4.models.Institute;
import com.example.webLab4.models.StudentAdder;

@WebServlet(name = "FacultyController", value = "/FacultyController")
public class FacultyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(request.getParameter("institute"));
        Institute institute = (Institute) session.getAttribute(request.getParameter("institute"));
        Faculty faculty = institute.getFacultyByName(request.getParameter("faculty"));
        request.setAttribute("institute", request.getSession().getAttribute(request.getParameter("institute")));
        request.setAttribute("faculty", faculty);
        request.getRequestDispatcher("WEB-INF/jsp/faculty.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Adder<Faculty> adder = new StudentAdder();
       Faculty faculty = adder.add(request);
       request.setAttribute("faculty", faculty);
       request.setAttribute("institute", request.getSession().getAttribute(request.getParameter("institute")));
       request.getRequestDispatcher("WEB-INF/jsp/faculty.jsp").forward(request, response);

    }
}
