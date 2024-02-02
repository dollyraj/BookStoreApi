package com.dolly.bookstoreapi.controller;

import com.dolly.bookstoreapi.model.Book;
import com.dolly.bookstoreapi.services.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    BookService bookService =new BookService();

    @GetMapping("/welcome")
    public ResponseEntity<String> greeting(){
        return new ResponseEntity<>("Welcome in our book store!", HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable String isbn){
        return bookService.getBookByISBN(isbn);
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<Book> updateBookByISBN(@PathVariable String isbn, @RequestBody Book book){
        return bookService.updateBookByISBN(isbn, book);
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<Book> deleteBookByISBN(@PathVariable String isbn) {

        return bookService.deleteBookByISBN(isbn);
    }

}

/*
a. GET /api/books: This endpoint should return a list of all books in the bookstore.
b. GET /api/books/{isbn}: This endpoint should retrieve the book with the specified ISBN.
   If the book is not found, return an appropriate error response.
c. POST /api/books: This endpoint should allow users to add a new book to the bookstore.
   Ensure that the request body is properly validated, and return the newly added book in the response.
d. PUT /api/books/{isbn}: This endpoint should allow users to update an existing book's information based on the provided ISBN.
   If the book is not found, return an appropriate error response.
e. DELETE /api/books/{isbn}: This endpoint should allow users to delete a book based on the provided ISBN.
   If the book is not found, return an appropriate error response.


1.	Implement appropriate error handling for invalid requests (e.g., invalid ISBN format, missing required fields in the request body, etc.).
2.	Use an in-memory data store (e.g., a list) to store the book information temporarily.
3.	Write unit tests to test the functionality of your API endpoints.

//you are testing specific unit of code
//Implement isbn thing
//exception handling
//unit test case
//ambiguous handler
 */
