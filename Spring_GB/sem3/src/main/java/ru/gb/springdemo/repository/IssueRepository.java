package ru.gb.springdemo.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.gb.springdemo.model.Issue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class IssueRepository {

    private final List<Issue> issues;

    public IssueRepository() {
        this.issues = new ArrayList<>();
    }

    public void save(Issue issue) {
        // insert into ....
        issues.add(issue);
    }

    public Issue getByID(long id) {
        return issues.stream().filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public List<Issue> getIssuesByRader(long id) {
        return issues.stream().filter(it -> Objects.equals(it.getReaderId(), id))
                .toList();
    }
}
