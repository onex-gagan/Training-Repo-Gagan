package org.example.collectionsDemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseManagerTest {

    private CourseManager manager;

    @BeforeEach
    void setUp() {
        manager = new CourseManager();

        manager.addCourse("ENG101");
        manager.addCourse("SCI201");
        manager.addCourse("COM301");

        manager.enrollStudent("ENG101", "Alice");
        manager.enrollStudent("ENG101", "Bob");
        manager.enrollStudent("ENG101", "Alice");

        manager.enrollStudent("SCI201", "Eve");
        manager.enrollStudent("SCI201", "Frank");
        manager.enrollStudent("SCI201", "Eve");

        manager.enrollStudent("COM301", "Ivan");
        manager.enrollStudent("COM301", "Judy");
    }

    @Test
    void testSortingCourses() {
        manager.sortCourses();
        assertEquals("COM301", manager.getCourses().get(0).getCourseName());
        assertEquals("ENG101", manager.getCourses().get(1).getCourseName());
        assertEquals("SCI201", manager.getCourses().get(2).getCourseName());
    }

    @Test
    void testFrequencyCount() {
        assertEquals(2, manager.getStudentEnrollmentCount("ENG101", "Alice"));
        assertEquals(0, manager.getStudentEnrollmentCount("ENG101", "Charlie"));
    }

    @Test
    void testNonExistentCourse() {
        int count = manager.getStudentEnrollmentCount("MATH101", "Ghost");
        assertEquals(0, count);
    }
}
