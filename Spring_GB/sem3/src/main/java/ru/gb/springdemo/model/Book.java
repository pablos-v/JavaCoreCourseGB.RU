package ru.gb.springdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "books")
@Schema(name = "Книга")
public class Book {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 100)
  @Schema(name = "Название книги")
  private String name;

  public Book(String name) {
    this.name = name;
  }

  public Book() {
  }
}
