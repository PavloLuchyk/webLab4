package com.example.webLab4.models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class StudentAdder implements Adder<Faculty> {
    @Override
    public Faculty add(HttpServletRequest request){
        HttpSession session = request.getSession();
        Institute institute = (Institute) session.getAttribute(request.getParameter("institute"));
        Faculty faculty = institute.getFacultyByName(request.getParameter("faculty"));
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String gradebookId = request.getParameter("gradebook_id");
        String averageMark = request.getParameter("average_mark");
        faculty.addStudent(firstName,lastName,gradebookId,Double.parseDouble(averageMark));
        return faculty;
    }
}
