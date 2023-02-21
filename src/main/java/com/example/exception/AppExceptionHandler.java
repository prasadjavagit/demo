package com.example.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException dataNotFoundException) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), dataNotFoundException.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataAlreadyExistException.class)
    public ResponseEntity resolveDataAlreadyExisstException(DataAlreadyExistException dataAlreadyExistException) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), dataAlreadyExistException.getMessage());
        return new ResponseEntity(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOtherExceptions(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), exception.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
