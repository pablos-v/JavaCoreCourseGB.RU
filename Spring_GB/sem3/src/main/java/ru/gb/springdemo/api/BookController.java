package ru.gb.springdemo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.service.BookService;

@Controller
public class BookController {

    private BookService service;

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getById(@PathVariable long id) {
        Book book = service.getBookById(id);
        if (book != null) return ResponseEntity.status(HttpStatus.OK).body(book);
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Book> delByID(@PathVariable long id) {
        Book book = service.getBookById(id);
        if (book != null) return ResponseEntity.ok(service.deleteBookById(id));
        else return ResponseEntity.badRequest().build();
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.OK).body(service.addBook(book));
    }

}
