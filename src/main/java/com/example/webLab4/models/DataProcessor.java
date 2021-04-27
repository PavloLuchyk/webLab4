package com.example.webLab4.models;

import java.util.ArrayList;
import java.util.Iterator;

public class DataProcessor {

    //Метод знаходження загального числа студентів
    public static int getTotalNumberOfStudents(Institute institute) {
        if (institute.getFaculties().isEmpty()){
            throw new NullPointerException("There is no faculties");
        }
        int number = 0;
        for (Faculty faculty: institute.getFaculties()){
            number += faculty.getNumberOfStudents();
        }
        return number;
    }

    //Метод знаходження факультету з найбільшим числом студентів
    public static Faculty getbiggestFaculty(Institute institute){
        if (institute.getFaculties().isEmpty()){
            throw new NullPointerException("There is no faculties");
        }
        Faculty max = new Faculty("Empty");
        Faculty faculty;
        for(Iterator<Faculty> i = institute.getFaculties().iterator(); i.hasNext();){
            faculty = i.next();
            if (max.getNumberOfStudents() < faculty.getNumberOfStudents()){
                max = faculty;
            }
        }
        return max;
    }

    //Метод знаходження студентів з найвищими балами
    public static ArrayList<Student> getStudentWithHighestMarks(Institute institute){
        if (institute.getFaculties().isEmpty()){
            throw new NullPointerException("There is no faculties");
        }
        ArrayList<Student> highMarks = new ArrayList<>();
        for(Iterator i = institute.getFaculties().iterator(); i.hasNext();){
            Object obj = i.next();
            if (obj instanceof Faculty){
                Faculty faculty = (Faculty) obj;
                ArrayList<Student> students = faculty.getStudents();
                for (Iterator j = students.iterator(); j.hasNext(); ){
                    Object o = j.next();
                    if (o instanceof Student){
                        Student student = (Student) o;
                        if (student.getAverageMark() >= 95 && student.getAverageMark() <= 100){
                            highMarks.add(student);
                        }
                    }
                }
            }
        }
        return highMarks;
    }

    public static void testFill(Institute institute) {
        Faculty fict = new Faculty("FICT");
        fict.addStudent(new Student("Ivan", "Ivanov", "IT-321", 90.1));
        fict.addStudent(new Student("Petro", "Fedorenko", "IT-232", 95.9));
        fict.addStudent(new Student("Ivan", "Oleksandrenko", "IT-21", 75));
        fict.addStudent("Anastasiya", "Vasileva", "IL -001", 95.0);
        fict.addStudent("Anna", "Makarenko", "UI-301", 100.0);
        Faculty iasa = new Faculty("IASA");
        iasa.addStudent(new Student("Valeriy", "Mensa", "KA-123", 96.7));
        iasa.addStudent(new Student("Petro", "Melenko", "AK-901", 80.5));
        iasa.addStudent(new Student("Vasyl", "Romanko", "PH-21", 75));
        Faculty iat = new Faculty("IAT");
        iat.addStudent(new Student("Serhiy", "Korolev", "RE-1", 100.0));
        iat.addStudent(new Student("Volodymyr", "Lidovskiy", "Am-321", 95.91));
        iat.addStudent(new Student("Ihor", "Molochar", "KE-3223", 60));
        iat.addStudent(new Student("Oleksiy", "Dovbush", "AE-434", 86.1));
        institute.addFaculty(fict);
        institute.addFaculty(iasa);
        institute.addFaculty(iat);
    }


}
