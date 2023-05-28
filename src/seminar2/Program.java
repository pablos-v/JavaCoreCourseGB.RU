package seminar2;

import java.util.Random;
import java.util.Scanner;

public class Program {
    /**
     * * Переработать метод проверки победы, логика проверки победы
     * должна работать для поля 5х5 и количества фишек 4
     */

    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '•';

    private static final Scanner SCANNER = new Scanner(System.in);

    private static char[][] field; // Двумерный массив хранит текущее состояние игрового поля

    private static final Random random = new Random();

    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля


    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Компьютер победил!"))
                    break;
            }
            System.out.println("Желаете сыграть еще раз? (Y - да)");
            if (!SCANNER.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    private static void initialize() {
        // Установим размерность игрового поля
        fieldSizeX = 5;
        fieldSizeY = 5;


        field = new char[fieldSizeX][fieldSizeY];
        // Пройдем по всем элементам массива
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                // Проинициализируем все элементы массива DOT_EMPTY (признак пустого поля)
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     * //TODO: Поправить отрисовку игрового поля
     */
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSizeY; j++)
                System.out.print(field[i][j] + "|");

            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты хода X и Y (от 1 до 3) через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка, ячейка является пустой
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность массива, игрового поля)
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Ход компьютера
     */
    private static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка победы
     * TODO: Переработать метод в домашнем задании
     *
     * @param c
     * @return
     */
    static boolean checkWin(char c) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == c) {
                    int h = checkHorisontal(c, i, j);
                    int v = checkVertical(c, i, j);
                    int d1 = checkDiagonal1(c, i, j);
                    int d2 = checkDiagonal2(c, i, j);
                    if (h == WIN_COUNT || v == WIN_COUNT || d1 == WIN_COUNT || d2 == WIN_COUNT) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /***
     * проверить вертикаль только вниз
     * @param c
     * @return
     */
    static int checkVertical(char c, int x, int y) {
        int count = 1;
        while (x < fieldSizeX) {
            x += 1;
            if (x == fieldSizeX) return count;
            if (field[x][y] == c) count += 1;
            else return count;
        }
        return count;
    }

    /**
     * проверить горизонталь только вправо
     *
     * @param c
     * @return
     */
    static int checkHorisontal(char c, int x, int y) {
        int count = 1;
        while (y < fieldSizeY) {
            y += 1;
            if (y == fieldSizeY) return count;
            if (field[x][y] == c) count += 1;
            else return count;
        }
        return count;
    }

    /**
     * проверить верикаль вправо-вверх
     *
     * @param c
     * @return
     */
    static int checkDiagonal1(char c, int x, int y) {
        int count = 1;
        while (x > 0 && y < fieldSizeY) {
            x -= 1;
            y += 1;
            if (x <=0 || y >= fieldSizeY) return count;
            if (field[x][y] == c) count += 1;
            else return count;
        }
        return count;
    }
    /**
     * проверить верикаль вправо-вниз
     *
     * @param c
     * @return
     */
    static int checkDiagonal2(char c, int x, int y) {
        int count = 1;
        while (x < fieldSizeX && y < fieldSizeY) {
            x += 1;
            y += 1;
            if (x >= fieldSizeX|| y >= fieldSizeY) return count;
            if (field[x][y] == c) count += 1;
            else return count;
        }
        return count;
    }


    /**
     * Проверка на ничью
     *
     * @return
     */
    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++)
                if (isCellEmpty(x, y)) return false;
        }
        return true;
    }

    /**
     * Метод проверки состояния игры
     *
     * @param c
     * @param str
     * @return
     */
    static boolean gameCheck(char c, String str) {
        if (checkWin(c)) {
            System.out.println(str);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }

}
