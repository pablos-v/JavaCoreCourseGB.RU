package ru.gb.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springdemo.model.Book;
import java.util.List;
import java.util.Optional;

public interface NewBookRepository extends JpaRepository<Book, Long> {

    @Override
    Optional<Book> findById(Long aLong);

    @Override
    List<Book> findAll();

    @Override
    <S extends Book> S save(S entity);

    @Override
    void deleteById(Long aLong);

}
