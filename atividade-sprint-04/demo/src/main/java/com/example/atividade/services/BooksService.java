package com.example.atividade.services;

import com.example.atividade.domain.Book;
import com.example.atividade.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// A anotação @Service indica que esta classe é um componente de serviço.//
@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    // Metodo para encontrar todos os livros.
    // Utiliza o metodo findAll do BooksRepository para obter a lista completa de livros.
    public List<Book> findAll() {

        return booksRepository.findAll();
    }

    // Metodo para excluir um livro com base no título.
    // Encontra todos os livros e filtra aqueles que têm o título especificado.
    // Em seguida, exclui cada livro encontrado pelo ID.//
    public void deleteBookByTitle(String title) {
        booksRepository.findAll().stream()
                .filter(book -> book.getTitle().equals(title))
                .forEach(book -> booksRepository.deleteById(book.getId()));
    }

    // Metodo para atualizar o ano de um livro com base no título.
    // Encontra o livro pelo título, lança uma exceção se o livro não for encontrado,
    // atualiza o ano do livro e salva as alterações no repositório.//
    public void updateBookYear(String title, int newYear) {
        Book book = booksRepository.findAll().stream()
                .filter(b -> b.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setYear(String.valueOf(newYear));
        booksRepository.save(book);
    }

    // Metodo para encontrar livros por autor.
    // Utiliza o metodo findByAutor do BooksRepository para obter livros de um autor específico.//
    public List<Book> findBooksByAuthor(String autor) {
        return booksRepository.findByAutor(autor);
    }

    // Metodo para encontrar livros publicados após um determinado ano.
    // Utiliza o metodo findByYearGreaterThan do BooksRepository para obter livros publicados após o ano especificado.//
    public List<Book> findBooksPublishedAfter(int year) {
        return booksRepository.findByYearGreaterThan(String.valueOf(year));
    }
}
