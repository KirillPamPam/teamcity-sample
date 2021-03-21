package com.example.dbsample.service;

import com.example.dbsample.model.db.Author;
import com.example.dbsample.model.request.AuthorRequest;
import com.example.dbsample.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional
    public void saveAuthor(AuthorRequest authorRequest) {
        authorRepository.save(new Author(authorRequest.getName(), authorRequest.getLastName()));
    }

    @Transactional(readOnly = true)
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Author findById(int id) {
        return authorRepository.findById(id).orElseThrow();
    }
}
