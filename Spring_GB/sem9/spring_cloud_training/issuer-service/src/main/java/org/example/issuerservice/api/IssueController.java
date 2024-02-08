package org.example.issuerservice.api;

import com.github.javafaker.Faker;
import org.example.Issue;
import org.example.issuerservice.BookProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.*;

@RestController
@RequestMapping("/api/issue")
public class IssueController {
    private final BookProvider provider;
    private final Faker fake;

    private final List<Issue> issues;

    public IssueController(BookProvider provider) {
        this.provider = provider;
        this.fake = new Faker();
        this.issues = new ArrayList<>();

    }

    @GetMapping
    public List<Issue> getAll() {
        return issues;
    }

    @GetMapping("/refresh")
    public List<Issue> refresh() {
        refreshData();
        return issues;
    }

    private void refreshData() {
        issues.clear();
        for (int i = 0; i < 15; i++) {
            Issue issue = new Issue();
            issue.setId(UUID.randomUUID());

            Date between = fake.date().between(startOfYear(), endOfYear());
            issue.setIssuedAt(between.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            issue.setBookId(provider.getRandomBookId());
            issue.setReaderId(UUID.randomUUID());

            issues.add(issue);
        }
    }

    private Date startOfYear() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, Calendar.JANUARY);
        instance.set(Calendar.DAY_OF_MONTH, 1);
        return instance.getTime();
    }

    private Date endOfYear() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, Calendar.DECEMBER);
        instance.set(Calendar.DAY_OF_MONTH, 31);
        return instance.getTime();
    }
}
