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

    public void deleteBookByTitle(String title) {
        booksRepository.findAll().stream()
                .filter(book -> book.getTitle().equals(title))
                .forEach(book -> booksRepository.deleteById(book.getId()));
    }

    public void updateBookYear(String title, int newYear) {
        Book book = booksRepository.findAll().stream()
                .filter(b -> b.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setYear(String.valueOf(newYear));
        booksRepository.save(book);
    }

    public List<Book> findBooksByAuthor(String autor) {
        return booksRepository.findByAutor(autor);
    }

    public List<Book> findBooksPublishedAfter(int year) {
        return booksRepository.findByYearGreaterThan(String.valueOf(year));
    }
}
