package ru.gb.springdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "issues")
@Entity
@Schema(name = "Выдача", description = "Фиксирует какая книга(ID) какому читателю(ID) выдана")
public class Issue {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Schema(name = "ID книги")
    private long bookId;
    @Schema(name = "ID читателя")
    private long readerId;
    @Schema(name = "Дата выдачи")
    private LocalDateTime timestamp;

    public Issue() {
    }

    public Issue(long bookId, long readerId) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.timestamp = LocalDateTime.now();
    }
}
