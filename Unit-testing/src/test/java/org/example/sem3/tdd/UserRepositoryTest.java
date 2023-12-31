package org.example.sem3.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.Query;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private UserRepository repository;

    @BeforeEach
    void setUp() {
        repository = new UserRepository();
    }

    @Test
    void addUser() {
        User user = new User("Ivan", "pass33", false);
        repository.addUser(user);

        assertEquals(user, repository.data.get(0));
    }
}