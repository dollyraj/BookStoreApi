package com.dolly.bookstoreapi.services;

import com.dolly.bookstoreapi.exception.ForbiddenException;
import com.dolly.bookstoreapi.exception.ResourceAlreadyExistsException;
import com.dolly.bookstoreapi.exception.ResourceNotFoundException;
import com.dolly.bookstoreapi.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    List<Book> bookList =new ArrayList<>();
    public ResponseEntity<Book> addBook(Book book){
        if(!book.getISBN().startsWith("ISBN"))
            throw new ForbiddenException("ISBN should be in a string format starting with ISBN");
        for(Book b: bookList){
            if(b.getISBN().equals(book.getISBN()))
                throw new ResourceAlreadyExistsException("Book with given id "+ book.getISBN()+" already exists");

        }

        bookList.add(book);
        return new ResponseEntity<>(book,HttpStatus.CREATED);
    }
    public ResponseEntity<List<Book>> getAllBooks(){
        if(bookList.isEmpty())
            throw new ResourceNotFoundException("No book found");
        else
            return new ResponseEntity<>(bookList,HttpStatus.OK);
    }



    public ResponseEntity<Book> getBookByISBN(String isbn){
        for(Book b: bookList) {
            if (b.getISBN().equals(isbn))
                return new ResponseEntity<>(b, HttpStatus.OK);
        }
        throw new ResourceNotFoundException("The book with given "+isbn+" is not found");


    }

    public ResponseEntity<Book> updateBookByISBN(String isbn, Book book) {
        for (Book b : bookList) {
            if (b.getISBN() == isbn) {
                b.setAuthor(book.getAuthor());
                b.setISBN(book.getISBN());
                b.setPrice(book.getPrice());
                b.setTitle(book.getTitle());
                return new ResponseEntity<>(b, HttpStatus.OK);
            }
        }
        throw new ResourceNotFoundException("The book with given " + isbn + " is not found");

    }

    public ResponseEntity<Book> deleteBookByISBN(String isbn) {
        for(Book b: bookList){
            if(b.getISBN()==isbn){
                bookList.remove(b);
                return new ResponseEntity<>(b, HttpStatus.OK);
            }

        }
        throw new ResourceNotFoundException("The book with given " + isbn + " is not found");
    }

}
