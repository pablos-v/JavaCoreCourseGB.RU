package ru.gb.springdemo.service;

import ru.gb.springdemo.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(long id);

    void deleteBookById(long id);

    Book addBook(Book book);

}
