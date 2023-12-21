package org.example.lec2;

public class Calculator {

    /**
     * В классе Calculator создайте метод calculateDiscount, который принимает сумму покупки и процент скидки и
     * возвращает сумму с учетом скидки.
     * Ваша задача - проверить этот метод с использованием библиотеки AssertJ. Если метод calculateDiscount
     * получает недопустимые аргументы, он должен выбрасывать исключение ArithmeticException.
     * Не забудьте написать тесты для проверки этого поведения.
     * @param purchaseAmount сумма покупки
     * @param discountAmount размер скидки
     * @return сумма с учетом скидки
     */
    public static double calculateDiscount(double purchaseAmount, int discountAmount) {
        if (purchaseAmount < 0 || discountAmount < 0 || discountAmount > 100) {
            throw new ArithmeticException("Check input data!");
        }

        return purchaseAmount - (purchaseAmount * (float)discountAmount/100);
    }
}