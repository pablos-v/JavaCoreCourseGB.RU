package ru.gb.springdemo.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.springdemo.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ReaderRepository {

    private final List<Reader> readers;

    public ReaderRepository() {
        this.readers = new ArrayList<>();
    }

    @PostConstruct
    public void generateData() {
        readers.addAll(List.of(
                new ru.gb.springdemo.model.Reader("Игорь")
                , new ru.gb.springdemo.model.Reader("Вася")
                , new ru.gb.springdemo.model.Reader("Слава")
        ));
    }

    public Reader getById(long id) {
        return readers.stream().filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Reader delById(long id) {
        return readers.remove((int) id);
    }

    public Reader addReader(Reader reader) {
        readers.add(reader);
        return reader;
    }
}
