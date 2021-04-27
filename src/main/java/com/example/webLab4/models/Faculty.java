package com.example.webLab4.models;
import java.io.Serializable;
import java.util.ArrayList;

public class Faculty implements Serializable {
    private String name;
    private ArrayList<Student> students;

    public Faculty(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    //Метод знаходження числа студетів на факультеті
    public int getNumberOfStudents() {
        return students.size();
    }

    //Методи додавання студента
    public void addStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("Null value cannot be added");
        }
        if (students.contains(student)) {
            throw new IllegalArgumentException("This student is already in list");
        }
        students.add(student);
    }

    public void addStudent(String firstName, String lastName, String gradeBookId, double averageMark) {
        Student student = new Student(firstName, lastName, gradeBookId, averageMark);
        addStudent(student);
    }

    //Метод видалення студента
    public void removeStudent(Student student) {
        if (students.isEmpty()) {
            throw new NullPointerException("List of students of faculty: " + name + " is empty");
        }
        if (student == null) {
            throw new NullPointerException("Null value cannot be removed");
        }
        students.remove(student);
        students.trimToSize();
    }

    public int getSize(){
        return students.size();
    }
}
