package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("MOby dik")
    private String name;
    @Value("Dick Mobiev")
    private String author;

    @Value("2001")
    private String year;

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }


    public String getName() {
        return name;
    }
}
