package ru.gb.springdemo.service;

import ru.gb.springdemo.api.IssueRequest;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.Reader;

import java.util.List;

public interface IssuerService {
    Issue issue(IssueRequest request);

    String getInfoById(long id);

    Book getBookByIssue(Issue issue);

    Reader getReaderByIssue(Issue issue);

    List<Issue> getAllIssues();

}
