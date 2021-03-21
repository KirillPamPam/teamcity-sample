package com.example.dbsample.model.response;

import com.example.dbsample.model.db.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private int id;
    private String name;
    private String lastName;
    private Set<Book> books;
}
