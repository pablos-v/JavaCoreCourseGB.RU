package ru.gb.springdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 100)
  private String name;

  public Book(String name) {
    this.name = name;
  }

  public Book() {
  }
}
