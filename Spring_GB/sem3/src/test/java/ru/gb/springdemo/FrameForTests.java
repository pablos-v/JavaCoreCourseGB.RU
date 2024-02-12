package ru.gb.springdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.api.IssueRequest;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.service.BookService;
import ru.gb.springdemo.service.IssuerService;
import ru.gb.springdemo.service.ReaderService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class FrameForTests {

    @Autowired
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    protected WebTestClient webTestClient;
    @Autowired
    protected BookService bookService;
    @Autowired
    protected ReaderService readerService;
    @Autowired
    protected IssuerService issuerService;

    //    @PostConstruct
    protected void fillDatabase() {
        readerService.addReader(new Reader("Игорь"));
        readerService.addReader(new Reader("Вася"));
        readerService.addReader(new Reader("Слава"));

        bookService.addBook(new Book("война и мир"));
        bookService.addBook(new Book("метрвые души"));
        bookService.addBook(new Book("чистый код"));

        System.out.println("----------------------------------------------");
        System.out.println(readerService.getAllReaders());
        System.out.println(bookService.getAllBooks());
        System.out.println("----------------------------------------------");

        int start = (int) bookService.getAllBooks().getFirst().getId();
        for (int i = start; i < start + 3; i++) {
            issuerService.issue(new IssueRequest(i, i));
        }
    }

    protected void cleanDataBase() {
        long iter = readerService.getAllReaders().size();
        for (int i = 0; i < iter; i++) {
            readerService.deleteReaderById(readerService.getAllReaders().getFirst().getId());
        }

        iter = bookService.getAllBooks().size();
        for (int i = 0; i < iter; i++) {
            bookService.deleteBookById(bookService.getAllBooks().getFirst().getId());
        }

        iter = issuerService.getAllIssues().size();
        for (int i = 0; i < iter; i++) {
            issuerService.deleteIssueById(issuerService.getAllIssues().getFirst().getId());
        }
    }

}
