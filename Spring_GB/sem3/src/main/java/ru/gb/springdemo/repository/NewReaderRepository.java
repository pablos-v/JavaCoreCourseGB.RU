package ru.gb.springdemo.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springdemo.model.Reader;

import java.util.List;
import java.util.Optional;

public interface NewReaderRepository extends JpaRepository<Reader, Long> {


    @Override
    List<Reader> findAll();

    @Override
    Optional<Reader> findById(Long aLong);

    @Override
    <S extends Reader> S save(S entity);

    @Override
    void deleteById(Long aLong);
}
