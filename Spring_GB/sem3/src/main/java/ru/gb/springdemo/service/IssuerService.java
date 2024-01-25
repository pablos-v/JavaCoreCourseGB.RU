package ru.gb.springdemo.service;

import org.springframework.stereotype.Service;
import ru.gb.springdemo.api.IssueRequest;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.Reader;

import java.util.List;
import java.util.Scanner;

public interface IssuerService {
    Issue issue(IssueRequest request);

    //    public Issue issue(IssueRequest request) {
//        if (bookRepository.getBookById(request.getBookId()) == null) {
//            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
//        }
//        if (readerRepository.getById(request.getReaderId()) == null) {
//            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
//        }
//        // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)
//        if (readerRepository.getById(request.getReaderId()).hasOverlimit()) throw new OverLimitException();
//        readerRepository.getById(request.getReaderId()).incNumOfBooks();
//        Issue issue = new Issue(request.getBookId(), request.getReaderId());
//        issueRepository.save(issue);
//        return issue;
//    }
    String getInfoById(long id);
//    public String getInfoById(long id) {
//        Issue issue = issueRepository.getByID(id);
//        Reader reader = getReaderByIssue(issue);
//        Book book = getBookByIssue(issue);
//        return String.format("Книга %s выдана %s пользователю %s", book, issue.getTimestamp().toString(), reader);
//    }

    Book getBookByIssue(Issue issue);

    Reader getReaderByIssue(Issue issue);

    List<Issue> getAllIssues();

}
