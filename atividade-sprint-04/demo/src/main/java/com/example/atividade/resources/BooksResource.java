package com.example.atividade.resources;

import com.example.atividade.domain.Book;
import com.example.atividade.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksResource {

    @Autowired
    private  BooksService booksService;


    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> list = booksService.findAll();
        return ResponseEntity.ok(list);
    }
}
