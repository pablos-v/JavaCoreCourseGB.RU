package com.pablos.spring.mvc.rest.exception_handling;

// создаём собственный эксепшн, который сможем выкидывать в контроллере,
// и обрабатывать с помощью @ExceptionHandler
public class NoSuchEmployeeException extends RuntimeException {

    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
