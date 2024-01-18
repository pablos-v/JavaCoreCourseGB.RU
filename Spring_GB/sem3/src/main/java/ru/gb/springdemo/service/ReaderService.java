package ru.gb.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.IssueRepository;
import ru.gb.springdemo.repository.ReaderRepository;

import java.util.List;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
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
