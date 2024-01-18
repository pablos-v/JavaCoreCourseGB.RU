package ru.gb.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.api.IssueRequest;
import ru.gb.springdemo.hw.OverLimitException;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.BookRepository;
import ru.gb.springdemo.repository.IssueRepository;
import ru.gb.springdemo.repository.ReaderRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssuerService {

    // спринг это все заинжектит
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public Issue issue(IssueRequest request) {
        if (bookRepository.getBookById(request.getBookId()) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.getById(request.getReaderId()) == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }
        // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)
        if (readerRepository.getById(request.getReaderId()).hasOverlimit()) throw new OverLimitException();
        readerRepository.getById(request.getReaderId()).incNumOfBooks();
        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }

    public String getInfoById(long id) {
        Issue issue = issueRepository.getByID(id);
        Reader reader = readerRepository.getById(issue.getReaderId());
        Book book = bookRepository.getBookById(issue.getBookId());
        return String.format("Книга %s выдана %s пользователю %s", book, issue.getTimestamp().toString(), reader);
    }

}
