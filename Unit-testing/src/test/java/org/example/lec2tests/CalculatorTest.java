package org.example.lec2tests;

import org.example.lec2.Calculator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    public void correctlyCountingEvaluation() {
        assertThat(Calculator.calculateDiscount(100, 10)).isEqualTo(90);
    }

    @Test
    public void negativeAmountEvaluation() {
        assertThatThrownBy(() -> Calculator.calculateDiscount(-100, 10))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    public void negativeDiscountEvaluation() {
        assertThatThrownBy(() -> Calculator.calculateDiscount(100, -10))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    public void moreThanHundredDiscountEvaluation() {
        assertThatThrownBy(() -> Calculator.calculateDiscount(100, 110))
                .isInstanceOf(ArithmeticException.class);
    }


}
