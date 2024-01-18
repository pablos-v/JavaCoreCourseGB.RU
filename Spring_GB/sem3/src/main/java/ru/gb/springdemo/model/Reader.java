package ru.gb.springdemo.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Reader {

    public static long sequence = 1L;

    private final long id;
    private final String name;
    private int booksInHand;

    @Value("${application.max-allowed-books:1}")
    private int limit;

    public Reader(String name) {
        this(sequence++, name);
    }

    public void incNumOfBooks() {
        booksInHand++;
    }

    public void decNumOfBooks() {
        booksInHand--;
    }

    public boolean hasOverlimit() {
        return booksInHand > limit;
    }

}

