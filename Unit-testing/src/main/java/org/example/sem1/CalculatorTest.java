package org.example.sem1;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {

        assertThat(Calculator.calculateDiscount(100, 10)).isEqualTo(90);

        assertThatThrownBy(() -> Calculator.calculateDiscount(-100, 10))
                .isInstanceOf(ArithmeticException.class);
                
        assertThatThrownBy(() -> Calculator.calculateDiscount(100, -10))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(() -> Calculator.calculateDiscount(100, 110))
                .isInstanceOf(ArithmeticException.class);
                
    }
}
