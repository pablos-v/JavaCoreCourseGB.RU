package ru.gb.springdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Запись о факте выдачи книги (в БД)
 */
@Data
@Table(name = "issues")
@Entity
public class Issue {


  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;
  private long bookId;
  private long readerId;

  /**
   * Дата выдачи
   */
  private LocalDateTime timestamp;

  public Issue() {
  }

  public Issue(long bookId, long readerId) {
    this.bookId = bookId;
    this.readerId = readerId;
    this.timestamp = LocalDateTime.now();
  }
}
