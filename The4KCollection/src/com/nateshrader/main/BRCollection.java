package com.nateshrader.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BRCollection {

    public BRCollection(){
        createCollectionFromFile();
    }

    private List<BluRayDisc> bluRays = new ArrayList<>();

    private void createCollectionFromFile() {
        File bluraysfile = new File("blurays.txt");

        try (Scanner fileScanner = new Scanner(bluraysfile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] segmentsOfFile = line.split("\\|");
                BluRayDisc brd = new BluRayDisc(Integer.parseInt(segmentsOfFile[0]), segmentsOfFile[1], Integer.parseInt(segmentsOfFile[2]), segmentsOfFile[3], Integer.parseInt(segmentsOfFile[4]), segmentsOfFile[5], segmentsOfFile[6], BigDecimal.valueOf(Double.parseDouble(segmentsOfFile[7])), Boolean.parseBoolean(segmentsOfFile[8]));
                bluRays.add(brd);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Can't find the blurays.txt file for scanning. " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("An item from the blurays.txt file is in the wrong format or being parsed in the wrong format." + e.getMessage());
        }
    }

    public void displayAllAlphabetically(){
        for (BluRayDisc brd : bluRays){
            System.out.println(brd);
        }
    }
}
