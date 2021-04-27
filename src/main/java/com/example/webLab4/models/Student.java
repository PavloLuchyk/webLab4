package com.example.webLab4.models;

import java.util.Objects;

public class Student {

    private String firstName;
    private String lastName;
    private String gradebookId;
    private double averageMark;

    public Student(String firstName, String lastName, String gradebookId, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradebookId = gradebookId;
        this.averageMark = averageMark;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firsName) {
        this.firstName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGradebookId() {
        return gradebookId;
    }

    public void setGradebookId(String gradebookId) {
        this.gradebookId = gradebookId;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.averageMark, averageMark) == 0 && firstName.equals(student.firstName) && lastName.equals(student.lastName) && gradebookId.equals(student.gradebookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gradebookId, averageMark);
    }
}