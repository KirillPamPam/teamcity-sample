package com.example.dbsample.repository;

import com.example.dbsample.model.db.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
