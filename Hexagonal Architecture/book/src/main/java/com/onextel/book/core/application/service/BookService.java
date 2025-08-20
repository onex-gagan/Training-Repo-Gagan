package com.onextel.book.core.application.service;

import com.onextel.book.core.domain.model.Book;
import com.onextel.book.core.ports.inbound.BookUseCase;
import com.onextel.book.core.ports.outbound.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService implements BookUseCase {

    private final BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Long id, Book book) {
        if (bookRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Book not found with ID: " + id);
        }
        Book updatedBook = new Book(id, book.title(), book.author(), book.publicationYear());
        return bookRepository.save(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
