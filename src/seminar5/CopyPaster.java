package seminar5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyPaster {
    public static void copy(String sourceDir, String taretDir) throws IOException {
//        File folder = new File(sourceDir);
//        Files.createDirectory(Path.of(taretDir));
//
//        for (File file : folder.listFiles()) {
//            if (file.isFile()) {
//                Path source = Path.of(file.toURI());
//                Path destination = Path.of(taretDir + "/" + file.getName());
//                Files.copy(source, destination);
//            }
//        }
        File folder = new File(sourceDir);
        File folderTo = new File(taretDir);
        folderTo.mkdir();
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                try (InputStream source = new FileInputStream(file)) {
                    try (OutputStream destination = new FileOutputStream(taretDir + "/" + file.getName())) {
                        int c;
                        while ((c = source.read()) != -1)
                            destination.write(c);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CopyPaster.copy("./src/seminar3", "./backup");
    }
}
