package com.my.company.endpoint.rest.controller.health;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

@RestController
public class StoredController {

    private static final String FILE_PATH = "/tmp/stored-int.txt";

    @GetMapping("/stored-int")
    public String getStoredInt() throws IOException {
        File file = new File(FILE_PATH);

        if (file.exists()) {
            // Lire le nombre dans le fichier
            return Files.readString(file.toPath());
        } else {
            // Générer un nombre aléatoire
            String randomNumber = String.valueOf(new Random().nextInt(1_000_000));
            // Écrire dans le fichier
            Files.writeString(file.toPath(), randomNumber);
            return randomNumber;
        }
    }
}

