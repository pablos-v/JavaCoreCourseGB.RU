package ru.gb.springdemo.service;

import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.IssueRepository;
import ru.gb.springdemo.repository.ReaderRepository;

import java.util.List;

public class ReaderService {
    private ReaderRepository readerRepository;

    private IssueRepository issueRepository;

    public Reader getReaderById(long id) {
        return readerRepository.getById(id);
    }

    public Reader deleteReaderById(long id) {
        return readerRepository.delById(id);
    }

    public Reader addReader(Reader reader) {
        return readerRepository.addReader(reader);
    }

    public List<Issue> getAllIssues(long id) {
        return issueRepository.getIssuesByRader(id);
    }
}
