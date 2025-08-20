package com.onextel.book.core.ports.outbound;

import com.onextel.book.core.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
  Book save(Book book);
  Optional<Book> findById(Long id);
  List<Book> findAll();
  void deleteById(Long id);
}
