package org.example.lec1;
import static org.assertj.core.api.Assertions.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        assertThat(App.countIt(2, 6, "+")).isEqualTo(8);
        assertThat(App.countIt(2, 2, "-")).isEqualTo(0);
        assertThat(App.countIt(2, 7, "*")).isEqualTo(14);
        assertThat(App.countIt(100, 50, "/")).isEqualTo(2);

        assert App.countIt(2, 6, "+") == 8;

        // проверка, что исключение выброшено правильное
        assertThatThrownBy( () -> App.countIt(8, 4, "_"))
                .isInstanceOf(IllegalArgumentException.class);


    }

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
