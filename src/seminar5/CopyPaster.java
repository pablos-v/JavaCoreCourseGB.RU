package seminar5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyPaster {
    public static void copy(String sourceDir, String taretDir) throws IOException {
        File folder = new File(sourceDir);
        Files.createDirectory(Path.of(taretDir));

        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                Path source = Path.of(file.toURI());
                Path destination = Path.of(taretDir + "/" + file.getName());
                Files.copy(source, destination);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CopyPaster.copy("./src/seminar3", "./backup");
    }
}
