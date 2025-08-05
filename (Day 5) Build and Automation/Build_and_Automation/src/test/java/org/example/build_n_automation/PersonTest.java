package org.example.build_n_automation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testGetName() {
        Person person = new Person("Gagan");
        assertEquals("Gagan", person.getName());
    }

    @Test
    public void testSetName() {
        Person person = new Person("Initial");
        person.setName("Updated");
        assertEquals("Updated", person.getName());
    }
}
