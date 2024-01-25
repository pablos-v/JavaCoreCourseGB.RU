package ru.gb.springdemo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.repository.NewBookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final NewBookRepository repository;

//    @PostConstruct
//    private void generateData() {
//        addBook(new Book("война и мир"));
//        addBook(new Book("метрвые души"));
//        addBook(new Book("чистый код"));
//    }

    @Autowired
    public BookServiceImpl(NewBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book getBookById(long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public void deleteBookById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Book addBook(Book book) {
        return repository.save(book);
    }
}
