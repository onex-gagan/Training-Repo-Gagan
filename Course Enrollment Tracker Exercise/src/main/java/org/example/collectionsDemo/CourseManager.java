package org.example.collectionsDemo;

import java.util.*;

public class CourseManager {
    private final List<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
    }

    // Add a new course
    public void addCourse(String courseName) {
        courses.add(new Course(courseName));
    }

    // Enroll a student to a course
    public void enrollStudent(String courseName, String studentName) {
        try {
            Course course = findCourse(courseName);
            course.addStudent(studentName);
        } catch (NoSuchElementException e) {
            System.err.println("Error: Course '" + courseName + "' not found. Cannot enroll student '" + studentName + "'.");
        }
    }

    // Find course by name
    private Course findCourse(String courseName) {
        return courses.stream()
                .filter(c -> c.getCourseName().equalsIgnoreCase(courseName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Course not found: " + courseName));
    }

    // Sort courses alphabetically
    public void sortCourses() {
        courses.sort(Comparator.comparing(Course::getCourseName));
    }

    // Shuffle courses randomly
    public void shuffleCourses() {
        Collections.shuffle(courses);
    }

    public List<Course> getCourses() {
        return courses;
    }

    // Count frequency of a student in a given course
    public int getStudentEnrollmentCount(String courseName, String studentName) {
        try {
            Course course = findCourse(courseName);
            return Collections.frequency(course.getStudents(), studentName);
        } catch (NoSuchElementException e) {
            System.err.println("Error: " + e.getMessage());
            return 0;
        }
    }

    // Print formatted report
    public void printReport() {
        System.out.println("===== Course Enrollment Report =====");
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}
