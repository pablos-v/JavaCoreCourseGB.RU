package ru.gb.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.NewReaderRepository;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    private final NewReaderRepository repository;

    @Autowired
    public ReaderServiceImpl(NewReaderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Reader getReaderById(long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Reader not found"));
    }

    @Override
    public void deleteReaderById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Reader addReader(Reader reader) {
        return repository.save(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return repository.findAll();
    }

    @Override
    public Reader updateReader(Long id, Reader readerNew) {
        Reader readerToUpdate = getReaderById(id);
        readerToUpdate.setBooksInHand(readerNew.getBooksInHand());
        readerToUpdate.setBookLimit(readerNew.getBookLimit());
        return readerToUpdate;
    }

}
