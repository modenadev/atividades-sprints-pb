package com.example.atividade.config;

import com.example.atividade.domain.Book;
import com.example.atividade.repository.BooksRepository;
import com.example.atividade.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    BooksRepository booksRepository;

    @Override
    public void run(String... args) throws Exception {

        booksRepository.deleteAll();

        Book book = new Book(null, "George Orwell", "1984", "1949" ,"Ficção cientifica");
        Book domCasmuro = new Book(null,"Machado de Assis","Dom Casmurro","1899","Romance");
        Book lordOfRings = new Book(null, "J.R.R Tolkien", "The Lord of the Rings", "1954" ,"Fantasia");
        Book animalFarm = new Book(null, "George Orwell", "Animal Farm", "1945", "Fábula");

        booksRepository.saveAll(Arrays.asList(book,domCasmuro,lordOfRings,animalFarm));

    }
}
