package util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private static final String LOG_FILE = "log.txt";

    public static void registrar(String mensagem) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write(LocalDateTime.now() + ": " + mensagem + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}