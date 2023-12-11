package com.pablos.spring.mvc.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Аннотацией @ControllerAdvice отмечается класс,
// предоставляющий функциональность Global Exception Handler-а
public class GlobalExceptionHandler {

    @ExceptionHandler // обработает кривые запросы с невалидным ID, типа /api/employees/1000
    public ResponseEntity<Informer> handleException(NoSuchFieldException exception) {
        return new ResponseEntity<>(new Informer(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler // обработает все кривые запросы типа /api/employees/fr
    public ResponseEntity<Informer> handleException(Exception exception) {
        return new ResponseEntity<>(new Informer(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

}


