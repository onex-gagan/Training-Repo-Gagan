package com.onextel.book.core.ports.inbound;

import com.onextel.book.core.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookUseCase {
  Book createBook(Book book);
  Optional<Book> getBook(Long id);
  List<Book> getAllBooks();
  Book updateBook(Long id, Book book);
  void deleteBook(Long id);
}
