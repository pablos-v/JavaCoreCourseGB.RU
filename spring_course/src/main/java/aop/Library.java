package aop;

import org.springframework.stereotype.Component;

@Component
public class Library {
    public void getBook(){
        System.out.println(" Take book ");
        System.out.println("-----------------");
    }public void getMag(){
        System.out.println(" Take mag ");
        System.out.println("-----------------");
    }public void putBook(String person, Book book){
        System.out.println(" Put book ");
        System.out.println("-----------------");
    }public void putMag(){
        System.out.println(" Put mag ");
        System.out.println("-----------------");
    }
    public String returnBook(){
        int d = 1/0;
        System.out.println(" returnBook() working ");
        return "Bible";
    }

}
