package org.example.exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void testBookConstructorsAndGetters(){
        Book book = new Book("1", "RandomBook", "Rabindranath Tagore");

        assertEquals("1", book.getId());
        assertEquals("Rabindranath Tagore", book.getAuthor());
        assertEquals("RandomBook", book.getTitle());
        assertTrue(book.isAvailable());
    }

    @Test
    void testSetAvailable(){
        Book book = new Book("1", "RandomBook", "Rabindranath Tagore");
        book.setAvailable(false);
        assertFalse(book.isAvailable());

        book.setAvailable(true);
        assertTrue(book.isAvailable());
    }
}