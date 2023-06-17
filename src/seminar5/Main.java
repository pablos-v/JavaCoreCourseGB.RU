package seminar5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;

/**
 * 1. Cоздать пару-тройку текстовых файлов. Для упрощения (чтобы не разбираться с ко-
 * дировками) внутри файлов следует писать текст только латинскими буквами.
 * 2. Написать метод, осуществляющий конкатенацию (объединение) переданных ей в ка-
 * честве параметров файлов (не важно, в первый допишется второй или во второй пер-
 * вый, или файлы вовсе объединятся в какой-то третий);
 * 3. Написать метод поиска слова внутри файла
 * 4. —||— слова в папке
 */
public class Main {

    public String stringGenerator(int num) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(num);

        for (int i = 0; i < num; i++) {
            int index = rand.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }
        return sb.toString();
    }

    public void fileMerger(Path what, Path where) throws IOException {
        String source = Files.readString(what);
        Files.writeString(where, source, StandardOpenOption.APPEND);
    }

    public boolean wordFinder(Path file, String word) throws IOException {
        return Files.readString(file).contains(word);
    }

    public boolean wordDeepFinder(Path folder, String word) {

        return true;
    }

    public static void main(String[] args) throws IOException {
        Main program = new Main();
        Path file1 = Files.createFile(Path.of("./file1.txt"));
        Path file2 = Files.createFile(Path.of("./file2.txt"));

        Files.writeString(file1, program.stringGenerator(10));
        Files.writeString(file2, program.stringGenerator(20));

        program.fileMerger(file1, file2);

        System.out.println(program.wordFinder(file2, Files.readString(file1)));
    }
}
