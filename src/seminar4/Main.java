package seminar4;

/**
 * Задача:
 * 1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
 * подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
 * просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
 * ячейке лежит символ или текст вместо числа), должно быть брошено исключение
 * MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 * 3 В методе main() вызвать полученный метод, обработать возможные исключения
 * MyArraySizeException и MyArrayDataException и вывести результат расчета.
 */
public class Main {
    public static void main(String[] args) {
        final int SIZE = 4;

//        program(ArraysForTest.wrongSizeArray, SIZE);
//        program(ArraysForTest.wrongDataArray, SIZE);
        program(ArraysForTest.correctArray, SIZE);

    }

    public static void program(String[][] arr, int size) {
        try {
            ArraySummarizer summarizer = new ArraySummarizer(arr, size);
            System.out.println("Sum of elements: " + summarizer.sum());
        } catch (MyArraySizeException | MyArrayDataException e) {
            throw new RuntimeException(e);
        }
    }
}
