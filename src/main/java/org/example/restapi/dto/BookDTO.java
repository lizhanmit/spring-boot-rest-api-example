package org.example.restapi.dto;

import jakarta.validation.constraints.NotBlank;

public class BookDTO {

    // Do not want to expose field "id" through the API.

    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotBlank
    private String isbn;

    public BookDTO() {
    }

    public BookDTO(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
