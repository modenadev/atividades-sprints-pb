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


    // Metodo get que lista todos os livros. //
    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> list = booksService.findAll();
        return ResponseEntity.ok(list);
    }

    // Deleta o livro pelo titulo //
    @DeleteMapping("/delete/{title}")
    public void deleteBook(@PathVariable String title) {
        booksService.deleteBookByTitle(title);
    }

    // Atualiza o livro pelo titulo //
    @PutMapping("/update/{title}")
    public void updateBook(@PathVariable String title, @RequestParam String year) {
        booksService.updateBookYear(title, Integer.parseInt(year));
    }

    // Pega o livro pelo autor //
    @GetMapping("/autor/{autor}")
    public List<Book> getBooksByAutor(@PathVariable String autor) {
        return booksService.findBooksByAuthor(autor);
    }

    // Pega a lista de livros > ano definido //
    @GetMapping("/publishedAfter/{year}")
    public List<Book> getBooksPublishedAfter(@PathVariable int year) {
        return booksService.findBooksPublishedAfter(year);
    }
}
