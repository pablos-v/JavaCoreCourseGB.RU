package ru.gb.springdemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.service.ReaderService;

@RestController
public class ReaderController {
    @Autowired
    private ReaderService service;

    @GetMapping("/Reader/{id}")
    public ResponseEntity<Reader> getById(@PathVariable long id) {
        Reader reader = service.getReaderById(id);
        if (reader != null) return ResponseEntity.status(HttpStatus.OK).body(reader);
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/reader/{id}")
    public ResponseEntity<Reader> delByID(@PathVariable long id) {
        Reader reader = service.getReaderById(id);
        if (reader != null) return ResponseEntity.ok(service.deleteReaderById(id));
        else return ResponseEntity.badRequest().build();
    }

    @PostMapping("/reader")
    public ResponseEntity<Reader> addReader(@RequestBody Reader reader) {
        return ResponseEntity.status(HttpStatus.OK).body(service.addReader(reader));
    }
}
