package com.nateshrader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheCollection {

    private List<BluRayDisc> bluRays = new ArrayList<>();

    private void createCollectionFromFile() {
        File bluraysfile = new File("blurays.txt");

        try (Scanner fileScanner = new Scanner(bluraysfile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] segmentsOfFile = line.split("\\|");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Can't find the blurays.txt file for scanning. " + e.getMessage());
        }
    }
}
