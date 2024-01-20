package ru.gb.springdemo.view_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.service.BookService;
import ru.gb.springdemo.service.IssuerService;
import ru.gb.springdemo.service.ReaderService;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    BookService bookService;
    @Autowired
    ReaderService readerService;
    @Autowired
    IssuerService issuerService;

    @GetMapping("/ui/books")
    public String veiwAllBooks(Model model) {
        model.addAttribute("items", bookService.getAllBooks());
        model.addAttribute("mainTag", "List of Books");
        return "list";
    }

    @GetMapping("/ui/reader")
    public String veiwAllReaders(Model model) {
        model.addAttribute("items", readerService.getAllReaders());
        model.addAttribute("mainTag", "List of Readers");
        return "list";
    }

    @GetMapping("/ui/issues")
    public String table(Model model) {
        model.addAttribute("issuerService", issuerService);
        model.addAttribute("mainTag", "Table of Issues");
        return "table";
    }

}
