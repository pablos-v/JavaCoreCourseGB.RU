package seminar2;

import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final char DOT_X = 'X';
    private static final char DOT_0 = '0';
    private static final char DOT_EMPTY = '*';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static char[][] field;
    private static final Random random = new Random();
    private static int sizeX;
    private static int sizeY;

    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Enter coordinates: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }
        while (!isValidMove(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_X;
    }

    public static void botTurn() {
        int x, y;
        do {
            x = random.nextInt(sizeX);
            y = random.nextInt(sizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_0;
    }

    public static boolean isValidMove(int x, int y) {
        return x >= 0 && x < sizeX && y >= 0 && y < sizeY;
    }

    public static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    private static void init() {
        // size field set
        sizeX = 3;
        sizeY = 3;

        field = new char[sizeY][sizeX];

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void checkGameOver(){

    }
    private static void print() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----");
    }

    public static void main(String[] args) {
        init();
        print();
        while (true){
            playerTurn();
            print();
            // TODO check win
            botTurn();
            print();
            // TODO check win
        }
    }

}
