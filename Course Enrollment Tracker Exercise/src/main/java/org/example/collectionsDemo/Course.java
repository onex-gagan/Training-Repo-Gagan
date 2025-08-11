package org.example.collectionsDemo;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private List<String> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void addStudent(String studentName) {
        students.add(studentName);
    }

    public String getCourseName() {
        return courseName;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public String toString() {
        return courseName + " → " + students;
    }
}
