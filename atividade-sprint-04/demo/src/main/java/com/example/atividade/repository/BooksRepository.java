package com.example.atividade.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.atividade.domain.Book;


public interface BooksRepository extends MongoRepository<Book, String> {
}
