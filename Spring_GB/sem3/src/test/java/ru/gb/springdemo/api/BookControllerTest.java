package ru.gb.springdemo.api;

import org.junit.jupiter.api.*;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.springdemo.FrameForTests;
import ru.gb.springdemo.model.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookControllerTest extends FrameForTests {
//@BeforeEach
//void init(){
//    fillDatabase();
//}
//
//@AfterEach
//void clean(){
//    cleanDataBase();
//}
    @Test
    @Order(10)
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
    @Order(30)
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
    @Order(20)
    void getByIdNotFound() {
        webTestClient.get()
                .uri("/api/book/" + Long.MAX_VALUE)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    @Order(1)
    @Transactional
    void addBook() {
        Book book = new Book("test book");

        Book responseBook = webTestClient.post()
                .uri("/api/book")
                .bodyValue(book)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Book.class)
                .returnResult().getResponseBody();
        Book expected = bookService.getBookById(bookService.getAllBooks().getLast().getId());

        assertNotNull(responseBook);
        assertEquals(expected, responseBook);

    }

    @Test
    @Order(2)
    @Transactional
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