package com.dolly.bookstoreapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException exc) {
        HashMap<String,String> resp = new HashMap<>();

        exc.getFieldErrors().forEach(error-> resp.put(error.getField(),error.getDefaultMessage()));

        return new ResponseEntity(resp,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e){
        return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<String> handleResourceAlreadyExistsException(ResourceAlreadyExistsException e){
        return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<String> handleForbiddenException(ForbiddenException e){
        return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

}
