package org.example.exercise;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    void initialSetup(){
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    void testBookBorrowSuccess(){
        Book book =  new Book("1", "RandomBook", "Rabindranath Tagore");
        when(bookRepository.findById("1")).thenReturn(book);

        Book borrowed = bookService.borrowBook("1");
        assertFalse(borrowed.isAvailable());
        verify(bookRepository).save(book);
    }

    @Test
    void testBorrowBookNotFound(){
        when(bookRepository.findById("1")).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            bookService.borrowBook("1");
        });

        assertEquals("Book not found", exception.getMessage());
    }

    @Test
    void testBorrowedBookAlreadyBorrowed(){
        Book book = new Book("1", "1984", "Premchand");
        book.setAvailable(false);
        when(bookRepository.findById("1")).thenReturn(book);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            bookService.borrowBook("1");
        });

        assertEquals("Book is already borrowed", exception.getMessage());
    }

    @Test
    void testReturnBookSuccess() {
        Book book = new Book("1", "1984", "Premchand");
        book.setAvailable(false);
        when(bookRepository.findById("1")).thenReturn(book);

        Book returned = bookService.returnBook("1");

        assertTrue(returned.isAvailable());
        verify(bookRepository).save(book);
    }

    @Test
    void testReturnBookNotFound() {
        when(bookRepository.findById("1")).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookService.returnBook("1");
        });

        assertEquals("Book not found", exception.getMessage());
    }

    @Test
    void testReturnBookAlreadyAvailable() {
        Book book = new Book("1", "1984", "Premchand");
        book.setAvailable(true);
        when(bookRepository.findById("1")).thenReturn(book);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            bookService.returnBook("1");
        });

        assertEquals("Book was not borrowed", exception.getMessage());
    }

    @Test
    void testFindAvailableBooksByAuthor() {
        Book book1 = new Book("1", "1984", "Orwell");
        Book book2 = new Book("2", "Animal Farm", "Orwell");
        Book book3 = new Book("3", "Brave New World", "Huxley");

        List<Book> allAvailable = Arrays.asList(book1, book2, book3);
        when(bookRepository.findAllAvailableBooks()).thenReturn(allAvailable);

        List<Book> result = bookService.findAvailableBooksByAuthor("Orwell");

        assertEquals(2, result.size());
        assertTrue(result.contains(book1));
        assertTrue(result.contains(book2));
        assertFalse(result.contains(book3));
    }

}