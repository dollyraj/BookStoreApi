package com.dolly.bookstoreapi.model;


import jakarta.validation.constraints.NotNull;

public class Book {


    private int id;
    private String title;
    private String author;
    @NotNull(message = "ISBN is required field!")
    private String ISBN;
    private Double price;

    public Book(int id, String title, String author, String ISBN, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", price=" + price +
                '}';
    }
}
