package com.example.dbsample.service;

import com.example.dbsample.model.db.Author;
import com.example.dbsample.model.request.AuthorRequest;
import com.example.dbsample.repository.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @Test
    public void saveAuthor() {
        final AuthorRequest authorRequest = new AuthorRequest("name", "lastName");
        final Author author = new Author(authorRequest.getName(), authorRequest.getLastName());

        when(authorRepository.save(any(Author.class))).thenReturn(author);

        authorService.saveAuthor(authorRequest);

        verify(authorRepository).save(any(Author.class));
    }

    @Test
    public void getAllAuthors() {
        final List<Author> authors = List.of(
                new Author(1, "name", "last", Collections.emptySet()),
                new Author(12, "name1", "last1", Collections.emptySet())
        );
        when(authorRepository.findAll()).thenReturn(authors);

        final List<Author> actual = authorService.getAllAuthors();
        assertEquals(authors, actual);
    }

    @Test
    public void getAuthorById() {
        final int id = 1;
        final Author author = new Author(1, "name", "last", Collections.emptySet());

        when(authorRepository.findById(id)).thenReturn(Optional.of(author));

        final Author actual = authorService.findById(id);
        assertEquals(actual, actual);
    }

    @Test
    public void getAuthorByIdAndThrowException() {
        assertThrows(NoSuchElementException.class, () -> {
            final int id = 2;

            when(authorRepository.findById(id)).thenReturn(Optional.empty());

            authorService.findById(id);
        });
    }
}
