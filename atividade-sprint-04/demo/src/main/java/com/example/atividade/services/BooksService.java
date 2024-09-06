package com.example.atividade.services;

import com.example.atividade.domain.Book;
import com.example.atividade.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    public List<Book> findAll() {

        return booksRepository.findAll();
    }
}
