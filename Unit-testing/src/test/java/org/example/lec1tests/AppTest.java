package org.example.lec1tests;

import org.example.lec1.App;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AppTest {

    @Test
    public void additionExpressionEvaluation() {
        assertThat(App.countIt(2, 6, "+")).isEqualTo(8);
    }

    @Test
    public void multiplicationExpressionEvaluation() {
        assertThat(App.countIt(2, 7, "*")).isEqualTo(14);
    }

    @Test
    public void subtractionExpressionEvaluation() {
        assertThat(App.countIt(2, 2, "-")).isEqualTo(0);
    }

    @Test
    public void divisionExpressionEvaluation() {
        assertThat(App.countIt(100, 50, "/")).isEqualTo(2);
    }

    // проверка, что исключение выброшено правильное
    @Test
    public void exceptionExecutionEvaluation() {
        assertThatThrownBy(() -> App.countIt(8, 4, "_")).isInstanceOf(IllegalArgumentException.class);
    }


}
