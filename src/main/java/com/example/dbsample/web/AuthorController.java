package com.example.dbsample.web;

import com.example.dbsample.model.db.Author;
import com.example.dbsample.model.request.AuthorRequest;
import com.example.dbsample.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/author")
    public void saveAuthor(@RequestBody AuthorRequest authorRequest) {
        authorService.saveAuthor(authorRequest);
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

}
