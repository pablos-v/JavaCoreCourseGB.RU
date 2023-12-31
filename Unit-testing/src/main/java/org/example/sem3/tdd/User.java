package org.example.sem3.tdd;

import lombok.Data;

import java.util.Objects;

@Data
public class User {

    String name;
    String password;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;

    }

    public User() {

    }

    //3.6.
    public boolean authenticate(String name, String password) {

        return Objects.equals(name, this.name) && Objects.equals(password, this.password);
    }

}