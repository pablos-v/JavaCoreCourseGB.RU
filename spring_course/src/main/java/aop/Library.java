package aop;

import org.springframework.stereotype.Component;

@Component
public class Library {
    public void getBook(Book bk){
        System.out.print(" Take book ");
        System.out.println(bk.getName());
    }
}
