package org.example.collectionsDemo;

public class Main {
    public static void main(String[] args) {
        CourseManager manager = new CourseManager();

        // Adding courses
        manager.addCourse("ENG101");
        manager.addCourse("SCI201");
        manager.addCourse("COM301");

        // Enrolling students (with duplicates)
        manager.enrollStudent("ENG101", "Gagan");
        manager.enrollStudent("ENG101", "Aditya");
        manager.enrollStudent("ENG101", "Gagan");

        manager.enrollStudent("SCI201", "Tanmay");
        manager.enrollStudent("SCI201", "Ankur");
        manager.enrollStudent("SCI201", "Tanmay");

        manager.enrollStudent("COM301", "Anurag");
        manager.enrollStudent("COM301", "Vishnu");

        // Sorting courses
        manager.sortCourses();
        System.out.println("\nAfter Sorting:");
        manager.printReport();

        // Student frequency count
        System.out.println("\nFrequency of Aditya in ENG101: " +
                manager.getStudentEnrollmentCount("ENG101", "Aditya"));

        // Shuffling courses
        manager.shuffleCourses();
        System.out.println("\nAfter Shuffling:");
        manager.printReport();
    }
}
