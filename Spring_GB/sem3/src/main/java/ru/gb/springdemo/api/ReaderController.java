package ru.gb.springdemo.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.service.ReaderService;

import java.util.List;

@RestController
@Tag(name = "READER")
public class ReaderController {
    @Autowired
    private ReaderService service;

    @GetMapping("/reader/")
    @Operation(summary = "Список читателей", description = "Отдаёт полный список всех читателей")
    public ResponseEntity<List<Reader>> getAll() {
        return ResponseEntity.ok(service.getAllReaders());
    }

    @GetMapping("/reader/{id}")
    @Operation(summary = "Получить читателя", description = "Отдаёт читателя, которого находит по указанному ID")
    public ResponseEntity<Reader> getById(@PathVariable long id) {
        Reader reader = service.getReaderById(id);
        if (reader != null) return ResponseEntity.status(HttpStatus.OK).body(reader);
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/reader/{id}")
    @Operation(summary = "Удалить читателя", description = "Удаляет читателя, которого находит по указанному ID, и отдаёт его в ответе")
    public ResponseEntity<Reader> delByID(@PathVariable long id) {
        Reader reader = service.getReaderById(id);
        if (reader != null) return ResponseEntity.ok(reader);
        else return ResponseEntity.badRequest().build();
    }

    @PostMapping("/reader")
    @Operation(summary = "Добавить читателя", description = "Добавляет читателя, переданного в теле запроса, и отдаёт его в ответе")
    public ResponseEntity<Reader> addReader(@RequestBody Reader reader) {
        return ResponseEntity.status(HttpStatus.OK).body(service.addReader(reader));
    }
}
