package ru.gb.springdemo.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.service.BookService;

import java.util.List;

@RestController
@Tag(name = "BOOK") // название контроллера в /swagger-ui/index.html#/ можно одним тегом объединять разные контроллеры
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/book/")
    @Operation(summary = "Список книг", description = "Отдаёт полный список всех книг")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("/book/{id}")
    @Operation(summary = "Получить книгу", description = "Отдаёт книгу, которую находит по указанному ID")
    public ResponseEntity<Book> getById(@PathVariable long id) {
        try {
            Book book = service.getBookById(id);
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/book/{id}")
    @Operation(summary = "Удалить книгу", description = "Удаляет книгу, которую находит по указанному ID, и отдаёт её в ответе")
    public ResponseEntity<Book> delByID(@PathVariable long id) {
        Book book = service.getBookById(id);
        if (book != null) return ResponseEntity.ok(book);
        else return ResponseEntity.badRequest().build();
    }

    @PostMapping("/book")
    @Operation(summary = "Добавить книгу", description = "Добавляет книгу, переданную в теле запроса, и отдаёт её в ответе")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.OK).body(service.addBook(book));
    }

}
