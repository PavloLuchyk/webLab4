package com.example.webLab4.controllers;

import com.example.webLab4.models.DataProcessor;
import com.example.webLab4.models.Institute;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResultsController", value = "/ResultsController")
public class ResultsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Institute institute = (Institute) request.getSession().getAttribute(request.getParameter("institute"));
        request.setAttribute("institute", institute);
        request.setAttribute("numberOfStudents", DataProcessor.getTotalNumberOfStudents(institute));
        request.setAttribute("biggestFaculty", DataProcessor.getbiggestFaculty(institute));
        request.setAttribute("highestMarksStudents", DataProcessor.getStudentWithHighestMarks(institute));
        request.getRequestDispatcher("WEB-INF/jsp/results.jsp").forward(request, response);
    }


}
