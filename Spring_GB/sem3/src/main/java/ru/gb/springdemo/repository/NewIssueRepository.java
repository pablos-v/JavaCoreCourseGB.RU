package ru.gb.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springdemo.model.Issue;

import java.util.List;
import java.util.Optional;

public interface NewIssueRepository extends JpaRepository<Issue, Long> {
    @Override
    <S extends Issue> S save(S entity);

    @Override
    void deleteById(Long aLong);

    @Override
    List<Issue> findAll();

    @Override
    Optional<Issue> findById(Long aLong);
}
