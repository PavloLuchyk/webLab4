package com.example.webLab4.models;
import java.util.ArrayList;

public class Institute {
    private String name;
    private ArrayList<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    //Метод додавання факультету
    public void addFaculty(Faculty faculty) {
        if (faculty == null) {
            throw new NullPointerException("Faculty cannot be null!");
        }
        if (faculties.contains(faculty)) {
            throw new IllegalArgumentException("This faculty already exists!");
        }
        faculties.add(faculty);
    }

    //Метод видалення факультету
    public void removeFaculty(Faculty faculty) {
        if (faculty == null) {
            throw new NullPointerException("Null value cannot be removed");
        }
        faculties.remove(faculty);
        faculties.trimToSize();
    }

    public Faculty getFacultyByName(String name){
        for (Faculty faculty: faculties){
            if (faculty.getName().equals(name)){
                return faculty;
            }
        }
        throw new IllegalArgumentException("Faculty not found");
    }

    public int getSize(){
      return faculties.size();
    }

    @Override
    public String toString() {
        return "Name ot the institute: " + name + ". List of the faculties: " + faculties;
    }
}
