package ru.gb.springdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Data
@Table(name = "readers")
@Schema(name = "Читатель")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    @Schema(name = "Имя")
    private String name;
    @Schema(name = "Количество книг на руках")
    private int booksInHand;

    @Value("${application.max-allowed-books:1}")
    @Schema(name = "Лимит книг на руках")
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

