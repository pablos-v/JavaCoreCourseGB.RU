package ru.gb.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.repository.BookRepository;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book getBookById(long id){
        return bookRepository.getBookById(id);
    }

    public Book deleteBookById(long id){
        return bookRepository.delById(id);
    }

    public Book addBook(Book book){
        return bookRepository.addBook(book);
    }
}
