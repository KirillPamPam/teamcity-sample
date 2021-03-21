package com.example.dbsample.repository;

import com.example.dbsample.model.db.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
