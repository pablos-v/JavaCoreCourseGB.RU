package org.example.sem4.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    BookRepository repositoryMock;
    BookService bookService;

    @BeforeEach
    void setUp() {
        repositoryMock = mock(InMemoryBookRepository.class);
        bookService = new BookService(repositoryMock);
    }

    @Test
    void findBookById() {
        Book testBook = new Book("1", "Book1", "Author1");
        when(repositoryMock.findById("1")).thenReturn(testBook);

        Book result = bookService.findBookById("1");

        assertEquals(testBook, result);
    }

    @Test
    void findAllBooks() {
        List<Book> testList = List.of(
                new Book("1", "Book1", "Author1"),
                new Book("2", "Book2", "Author2"));
        when(repositoryMock.findAll()).thenReturn(testList);

        List<Book> result = bookService.findAllBooks();

        assertEquals(testList, result);
    }
}