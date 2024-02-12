package ru.gb.springdemo.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.hw.OverLimitException;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.api.IssueRequest;
import ru.gb.springdemo.service.IssuerService;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/api/issue")
@Tag(name = "ISSUE")
public class IssuerController {

    @Autowired
    private IssuerService service;

    @PostMapping
    @Operation(summary = "Выдать книгу читателю", description = "На основе переданного запроса IssueRequest, содержащего ID читателя и ID книги, создаёт и возвращает выдачу Issue")
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request) {
        log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());

        final Issue issue;
        try {
            issue = service.issue(request);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (OverLimitException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(issue);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить описание выдачи", description = "Отдаёт описание выдачи книги, опираясь на переданный ID выдачи")
    public String getIssueDescription(@PathVariable long id) {
        return service.getInfoById(id);
    }

}
