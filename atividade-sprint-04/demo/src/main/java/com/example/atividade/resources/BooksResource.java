package com.example.atividade.resources;

import com.example.atividade.domain.Book;
import com.example.atividade.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete/{title}")
    public void deleteBook(@PathVariable String title) {
        booksService.deleteBookByTitle(title);
    }

    @PutMapping("/update/{title}")
    public void updateBook(@PathVariable String title, @RequestParam String year) {
        booksService.updateBookYear(title, Integer.parseInt(year));
    }

    @GetMapping("/autor/{autor}")
    public List<Book> getBooksByAutor(@PathVariable String autor) {
        return booksService.findBooksByAuthor(autor);
    }

    @GetMapping("/publishedAfter/{year}")
    public List<Book> getBooksPublishedAfter(@PathVariable int year) {
        return booksService.findBooksPublishedAfter(year);
    }
}
