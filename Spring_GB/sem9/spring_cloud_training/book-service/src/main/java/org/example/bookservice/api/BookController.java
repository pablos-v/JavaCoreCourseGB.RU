package org.example.bookservice.api;

import com.github.javafaker.Faker;
import org.example.Author;
import org.example.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final Faker faker;
    private final List<Book> books;

    public BookController() {
        this.faker = new Faker();
        this.books = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Author author = new Author();
            author.setId(UUID.randomUUID());
            author.setName(faker.name().fullName());

            Book book = new Book();
            book.setId(UUID.randomUUID());
            book.setName(faker.book().title());
            book.setAuthor(author);
            books.add(book);
        }
    }

    @GetMapping
    public List<Book> getAll() {
        return books;
    }

    @GetMapping("/random")
    public Book getRandom() {
        final int randomIndex = ThreadLocalRandom.current().nextInt(books.size());
        return books.get(randomIndex);
    }
}
