package com.example.dbsample.service;

import com.example.dbsample.model.db.Author;
import com.example.dbsample.model.db.Book;
import com.example.dbsample.model.request.BookRequest;
import com.example.dbsample.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Transactional
    public void saveBook(BookRequest bookRequest) {
        final Author author = authorService.findById(bookRequest.getAuthorId());

        bookRepository.save(new Book(bookRequest.getName(), author));
    }
}
