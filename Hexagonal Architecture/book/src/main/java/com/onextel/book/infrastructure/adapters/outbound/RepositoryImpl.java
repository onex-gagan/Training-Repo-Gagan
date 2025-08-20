package com.onextel.book.infrastructure.adapters.outbound;

import com.onextel.book.core.domain.model.Book;
import com.onextel.book.core.ports.outbound.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class RepositoryImpl implements BookRepository {

    private final Map<Long, Book> database = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Book save(Book book) {
        Long id = (book.id() == null) ? idGenerator.getAndIncrement() : book.id();
        Book savedBook = new Book(id, book.title(), book.author(), book.publicationYear());
        database.put(id, savedBook);
        return savedBook;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public void deleteById(Long id) {
        database.remove(id);
    }
}
