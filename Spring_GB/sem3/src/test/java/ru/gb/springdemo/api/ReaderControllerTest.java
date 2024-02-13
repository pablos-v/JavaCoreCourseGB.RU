package ru.gb.springdemo.api;

import org.junit.jupiter.api.*;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.springdemo.FrameForTests;
import ru.gb.springdemo.model.Reader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderControllerTest extends FrameForTests {

    @Test
    void getAll() {
        List<Reader> responseBody = webTestClient.get()
                .uri("/api/reader")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Reader.class)
                .returnResult().getResponseBody();
        List<Reader> expected = readerService.getAllReaders();

        assertNotNull(responseBody);
        assertEquals(expected, responseBody);
    }

    @Test
    void getById() {
        long readerId = readerService.getAllReaders().getLast().getId();
        Reader responseBody = webTestClient.get()
                .uri("/api/reader/" + readerId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Reader.class)
                .returnResult().getResponseBody();
        Reader expected = readerService.getReaderById(readerId);

        assertNotNull(responseBody);
        assertEquals(expected, responseBody);
    }

    @Test
    void getByIdNotFound() {
        webTestClient.get()
                .uri("/api/reader/" + Long.MAX_VALUE)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    @Transactional
    void delByID() {
        long lastId = readerService.getAllReaders().getLast().getId();
        Reader expected = readerService.getReaderById(lastId);

        Reader response = webTestClient.delete()
                .uri("/api/reader/" + lastId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Reader.class)
                .returnResult().getResponseBody();

        assertNotNull(response);
        assertEquals(expected, response);
    }

    @Test
    @Transactional
    void addReader() {
        Reader reader = new Reader("test reader");

        Reader responseReader = webTestClient.post()
                .uri("/api/reader")
                .bodyValue(reader)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Reader.class)
                .returnResult().getResponseBody();
        Reader expected = readerService.getReaderById(readerService.getAllReaders().getLast().getId());

        assertNotNull(responseReader);
        assertEquals(expected, responseReader);
    }
}