package ru.gb.springdemo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.api.IssueRequest;
import ru.gb.springdemo.hw.OverLimitException;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.NewBookRepository;
import ru.gb.springdemo.repository.NewIssueRepository;
import ru.gb.springdemo.repository.NewReaderRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IssueServiceImpl implements IssuerService {
    NewReaderRepository readerRepository;
    NewIssueRepository issueRepository;
    NewBookRepository bookRepository;

    @PostConstruct
    public void emulateIssues() {
        readerRepository.save(new Reader("Игорь"));
        readerRepository.save(new Reader("Вася"));
        readerRepository.save(new Reader("Слава"));

        bookRepository.save(new Book("война и мир"));
        bookRepository.save(new Book("метрвые души"));
        bookRepository.save(new Book("чистый код"));

        for (int i = 1; i <= 3; i++) {
            issue(new IssueRequest(i, i));
        }
    }

    @Autowired
    public IssueServiceImpl(NewReaderRepository readerRepository, NewIssueRepository issueRepository, NewBookRepository bookRepository) {
        this.readerRepository = readerRepository;
        this.issueRepository = issueRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public Issue issue(IssueRequest request) {
        if (bookRepository.findById(request.getBookId()).isEmpty()) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.findById(request.getReaderId()).isEmpty()) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }
        // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)
        if (readerRepository.findById(request.getReaderId()).get().hasOverlimit()) throw new OverLimitException();
        readerRepository.findById(request.getReaderId()).get().incNumOfBooks();
        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }

    @Override
    public String getInfoById(long id) {
        Issue issue = issueRepository.findById(id).get();
        Reader reader = getReaderByIssue(issue);
        Book book = getBookByIssue(issue);
        return String.format("Книга %s выдана %s пользователю %s", book, issue.getTimestamp().toString(), reader);
    }

    @Override
    public Book getBookByIssue(Issue issue) {
        return bookRepository.findById(issue.getBookId()).get();
    }

    @Override
    public Reader getReaderByIssue(Issue issue) {
        return readerRepository.findById(issue.getReaderId()).get();
    }

    @Override
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }
}
