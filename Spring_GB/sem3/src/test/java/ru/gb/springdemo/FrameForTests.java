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

import java.util.List;

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
}


