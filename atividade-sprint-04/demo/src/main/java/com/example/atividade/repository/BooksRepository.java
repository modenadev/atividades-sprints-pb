package com.example.atividade.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.atividade.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

// Define a interface BooksRepository como um repositório para a entidade Book.//
@Repository
public interface BooksRepository extends MongoRepository<Book, String> {

    // Metodo para encontrar um livro pelo seu título.//
    Book findByTitle(String title);

    // Metodo para encontrar livros cujo ano é maior do que o ano fornecido.//
    List<Book> findByYearGreaterThan(String year);

    // Metodo para encontrar livros por autor //
    List<Book> findByAutor(String autor);
}


