package com.example.atividade.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "books")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String autor;
    private String title;
    private String year;
    private String genre;

    public Book() {

    }

    public Book(String id, String autor, String title, String year, String genre) {
        this.id = id;
        this.autor = autor;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book books = (Book) o;
        return Objects.equals(id, books.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
