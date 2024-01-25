package ru.gb.springdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Data
@Table(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    private int booksInHand;

    @Value("${application.max-allowed-books:1}")
    private int bookLimit;

    public Reader(String name) {
        this.name = name;
    }

    public Reader() {
    }

    public void incNumOfBooks() {
        booksInHand++;
    }

    public void decNumOfBooks() {
        booksInHand--;
    }

    public boolean hasOverlimit() {
        return booksInHand > bookLimit;
    }

}

