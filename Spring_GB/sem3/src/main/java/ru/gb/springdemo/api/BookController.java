package ru.gb.springdemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.service.BookService;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/book/")
    public ResponseEntity<List<Book>> getAll(){
        return ResponseEntity.ok(service.getAllBooks());
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getById(@PathVariable long id) {
        try {
            Book book = service.getBookById(id);
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Book> delByID(@PathVariable long id) {
        Book book = service.getBookById(id);
        if (book != null) return ResponseEntity.ok(book);
        else return ResponseEntity.badRequest().build();
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.OK).body(service.addBook(book));
    }

}
