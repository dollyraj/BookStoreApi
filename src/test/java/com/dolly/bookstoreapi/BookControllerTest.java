package com.dolly.bookstoreapi;

import com.dolly.bookstoreapi.controller.BookController;
import com.dolly.bookstoreapi.model.Book;
import com.dolly.bookstoreapi.services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class BookControllerTest {
    @Mock
    private BookService bookService;
    //When using Mockito Use @InjectMocks to inject
    //Mocked beans to following class
   @InjectMocks
    private BookController bookController;


    @Test
    public void getAllCourses(){
        //courseController.getAllCourses();
        //verify(courseService).getAllCourses();

        //given
        Book book=new Book( 1,"Java","Author1","isbn1",200.0);
        Book book2= new Book(2,"Spring Boot","Author2","isbn2",400.0);
        //When
        when(bookService.getAllBooks())
                .thenReturn(new ResponseEntity<>(List.of(book,book2), HttpStatus.OK));
        ResponseEntity<List<Book>> bookList = bookController.getAllBooks();
        //Then
        //Make sure to import assertThat From org.assertj.core.api package
        assertThat(bookList).isNotNull();
        assertThat(bookList.getBody().size()).isEqualTo(2);

    }
}
