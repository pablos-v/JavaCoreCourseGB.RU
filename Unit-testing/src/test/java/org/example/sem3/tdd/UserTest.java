package org.example.sem3.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    private User user;

    @BeforeEach
    void setup() {
        user = new User();
    }

    @ParameterizedTest
    @CsvSource({
            "ivan, pass1",
            "luna, pass2"
    })
    void userTest(String name, String pass) {
        user.name = name;
        user.password = pass;

        assertTrue(user.authenticate(name,pass));
    }
}