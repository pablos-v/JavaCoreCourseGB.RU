package org.example.lec1;
public class App {

    public static int countIt(int one, int two, String operator){
        return switch (operator) {
            case "/" -> one / two;
            case "*" -> one * two;
            case "-" -> one - two;
            case "+" -> one + two;
            default -> throw new IllegalArgumentException(operator);
        };
    }
}
