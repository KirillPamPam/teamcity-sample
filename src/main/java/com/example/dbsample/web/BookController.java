package com.example.dbsample.web;

import com.example.dbsample.model.request.BookRequest;
import com.example.dbsample.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/book")
    public void saveBook(@RequestBody BookRequest bookRequest) {
        bookService.saveBook(bookRequest);
    }
}
