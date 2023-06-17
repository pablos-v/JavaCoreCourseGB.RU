package seminar5;

import java.io.File;

public class Tree {

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     *
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast) {
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.print(indent); // рисуем отступ

        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }

        System.out.println(ANSI_YELLOW + file.getName() + ANSI_RESET);

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        int filesTotal = 0;
        for (File value : files) {
            if (value.isDirectory()) subDirTotal++;
            else filesTotal++;
        }

        int subDirCounter = 0;
        String pointer;
        for (File value : files) {
            if (value.isFile()) {
                pointer = filesTotal == 1 ? "└─" : "├─";
                System.out.println(indent + pointer + ANSI_GREEN + value.getName() + ANSI_RESET);
                filesTotal--;
            }
            if (value.isDirectory()) {
                print(value, indent, subDirCounter == subDirTotal - 1);
                subDirCounter++;
            }
        }
    }

    public static void main(String[] args) {
        Tree.print(new File("."), "", true);
    }
}
