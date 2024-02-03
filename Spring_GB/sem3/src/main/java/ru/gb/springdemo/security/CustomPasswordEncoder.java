package ru.gb.springdemo.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        // шифруем пароль
        return String.valueOf(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
// encodedPassword - это наш пароль из БД, который предварительно уже
// был прогнан через метод encode(CharSequence rawPassword)
}
