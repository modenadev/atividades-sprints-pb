package com.example.atividade.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.atividade.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends MongoRepository<Book, String> {

    Book findByTitle(String title);
}


