package ru.gb.springdemo.api;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rsocket.server.LocalRSocketServerPort;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;
import ru.gb.springdemo.FrameForTests;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.service.BookService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookControllerTest extends FrameForTests {
    Book testbook;
    @BeforeEach
    void init() {
        fillDatabase();
        testbook = new Book("new test book");
        testbook.setId(4);
    }

    @AfterEach
    void clean() {
        cleanDataBase();
    }

    @Test
    @Order(1)
    void getAll() {
        List<Book> responseBody = webTestClient.get()
                .uri("/api/book")
                .exchange()
                .expectStatus().isOk()
//                .expectBody(new ParameterizedTypeReference<List<Book>>() {})
                .expectBodyList(Book.class)
                .returnResult().getResponseBody();
        List<Book> expected = bookService.getAllBooks();

        assertNotNull(responseBody);
        assertEquals(expected, responseBody);
    }

    @Test
    @Order(3)
    void getById() {
        long bookId = bookService.getAllBooks().getLast().getId();
        Book responseBody = webTestClient.get()
                .uri("/api/book/" + bookId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Book.class)
                .returnResult().getResponseBody();
        Book expected = bookService.getBookById(bookId);

        assertNotNull(responseBody);
        assertEquals(expected, responseBody);
    }

    @Test
    @Order(2)
    void getByIdNotFound() {
        webTestClient.get()
                .uri("/api/book/" + Long.MAX_VALUE)
                .exchange()
                .expectStatus().isNotFound();


    }

    @Test
    @Order(10)
    void addBook() {
//        Book book = new Book("test book");
//        book.setId(7);
        List<Book> ls = bookService.getAllBooks();
        Book responseBook = webTestClient.post()
                .uri("/api/book/")
//                .bodyValue(book)
//                .body(Mono.just(book), Book.class)
//                .syncBody(book)
                .body(BodyInserters.fromObject(testbook))
                .exchange()
//                .expectStatus().isOk()
                .expectBody(Book.class)
                .returnResult().getResponseBody();
        List<Book> ls1 = bookService.getAllBooks();
        Book expected = bookService.getBookById(bookService.getAllBooks().getLast().getId());

        assertNotNull(responseBook);
        assertEquals(expected, responseBook);

    }

    @Test
    @Order(11)
    void delByID() {
        int size = bookService.getAllBooks().size();
        long lastId = bookService.getAllBooks().getLast().getId();
        Book expected = bookService.getBookById(lastId);

        Book response = webTestClient.delete()
                .uri("/api/book/" + lastId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Book.class)
                .returnResult().getResponseBody();
        assertNotNull(response);
        assertEquals(size - 1, bookService.getAllBooks().size());
        assertEquals(expected, response);
    }


}