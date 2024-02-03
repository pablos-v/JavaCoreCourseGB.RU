package ru.gb.springdemo.view_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.springdemo.service.BookService;
import ru.gb.springdemo.service.IssuerService;
import ru.gb.springdemo.service.ReaderService;

@Controller
public class MyController {
    public static final String MAIN_TAG = "mainTag";
    private final BookService bookService;
    private final ReaderService readerService;
    private final IssuerService issuerService;

    public MyController(BookService bookService, ReaderService readerService, IssuerService issuerService) {
        this.bookService = bookService;
        this.readerService = readerService;
        this.issuerService = issuerService;
    }

    @GetMapping("/ui/books")
    public String veiwAllBooks(Model model) {
        model.addAttribute("items", bookService.getAllBooks());
        model.addAttribute(MAIN_TAG, "List of Books");
        return "list";
    }

    @GetMapping("/ui/readers")
    public String veiwAllReaders(Model model) {
        model.addAttribute("items", readerService.getAllReaders());
        model.addAttribute(MAIN_TAG, "List of Readers");
        return "list";
    }

    @GetMapping("/ui/issues")
    public String table(Model model) {
        model.addAttribute("issuerService", issuerService);
        model.addAttribute(MAIN_TAG, "Table of Issues");
        return "table";
    }

}
