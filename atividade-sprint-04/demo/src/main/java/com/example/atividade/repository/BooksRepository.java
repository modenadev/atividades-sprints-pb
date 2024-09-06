package com.example.atividade.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.atividade.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends MongoRepository<Book, String> {

    Book findByTitle(String title);

    List<Book> findByYearGreaterThan(String year);

    List<Book> findByAutor(String autor);
}


