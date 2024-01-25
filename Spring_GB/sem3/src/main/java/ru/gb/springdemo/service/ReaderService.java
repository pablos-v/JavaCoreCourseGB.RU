package ru.gb.springdemo.service;

import ru.gb.springdemo.model.Reader;

import java.util.List;

public interface ReaderService {

    Reader getReaderById(long id);

    void deleteReaderById(long id);

    Reader addReader(Reader reader);

    List<Reader> getAllReaders();

    Reader updateReader(Long id, Reader reader);
}
