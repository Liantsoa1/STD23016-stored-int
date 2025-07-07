package com.my.company.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

public class Handler {

    private static final String FILE_PATH = "/tmp/stored-int.txt";

    public String getStoredInt() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try {
                return Files.readString(file.toPath()).trim();
            } catch (IOException e) {
                return "Erreur lecture : " + e.getMessage();
            }
        } else {
            int random = new Random().nextInt(1000);
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(String.valueOf(random));
            } catch (IOException e) {
                return "Erreur écriture : " + e.getMessage();
            }
            return String.valueOf(random);
        }
    }
}
