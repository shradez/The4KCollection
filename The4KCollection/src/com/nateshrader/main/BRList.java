package com.nateshrader.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class BRList {

    public BRList() {
        createListFromFile();
    }

    private final List<BluRayDisc> bluRays = new ArrayList<>();

    public List<BluRayDisc> getBluRays() {
        return bluRays;
    }

    public List<BluRayDisc> getBluRaysByGenre(String genre) {
        List<BluRayDisc> bluRaysByGenre = new ArrayList<>();
        for (BluRayDisc bluRayDisc : bluRays) {
            if (bluRayDisc.getGenre1().equals(genre) || bluRayDisc.getGenre2().equals(genre)) {
                bluRaysByGenre.add(bluRayDisc);
            }
        }
        return bluRaysByGenre;
    }

    public List<BluRayDisc> getBluRaysByMPAARating(String mPAARating) {
        List<BluRayDisc> bluRaysByMPAARating = new ArrayList<>();
        for (BluRayDisc bluRayDisc : bluRays) {
            if (bluRayDisc.getmPAARating().equals(mPAARating)) {
                bluRaysByMPAARating.add(bluRayDisc);
            }
        }
        return bluRaysByMPAARating;
    }

    public List<BluRayDisc> getBluRaysUnwatchedByNate() {
        List<BluRayDisc> bluRaysUnwatchedByNate = new ArrayList<>();
        for (BluRayDisc bluRayDisc : bluRays) {
            if (!bluRayDisc.hasNateWatched()) {
                bluRaysUnwatchedByNate.add(bluRayDisc);
            }
        }
        return bluRaysUnwatchedByNate;
    }


    private void createListFromFile() {
        File bluraysfile = new File("blurays.txt");

        try (Scanner fileScanner = new Scanner(bluraysfile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] segmentsOfFile = line.split("\\|");
                BluRayDisc brd = new BluRayDisc(Integer.parseInt(segmentsOfFile[0]), segmentsOfFile[1], Integer.parseInt(segmentsOfFile[2]), segmentsOfFile[3], Integer.parseInt(segmentsOfFile[4]), segmentsOfFile[5], segmentsOfFile[6], BigDecimal.valueOf(Double.parseDouble(segmentsOfFile[7])), Boolean.parseBoolean(segmentsOfFile[8]),
                        segmentsOfFile[9], segmentsOfFile[10]);
                bluRays.add(brd);

            }
        } catch (FileNotFoundException e) {
            System.err.println("Can't find the blurays.txt file for scanning. " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("An item from the blurays.txt file is in the wrong format or being parsed in the wrong format." + e.getMessage());
        }
    }

    public void displayAlphabetically(List<BluRayDisc> list) {
        System.out.println("\nHere are your chosen 4K Blu Rays, listed in alphabetical order: \n\n-------------------------\n");
        int i = 1;
        for (BluRayDisc brd : list) {
            String iFormatted = String.format("%02d", i);
            System.out.println(iFormatted + ". " + brd);
            i++;
        }
    }

    public void displayByIMDBRatingDescending(List<BluRayDisc> list) {
        System.out.println("\nHere are all the 4K BluRays in our collection, listed in order of IMDB's average user score, descending: \n\n-------------------------\n");
        list.sort(BluRayDisc.BRDIMDBScoreDescendingComparator);
        int i = 1;
        for (BluRayDisc brd : list) {
            String iFormatted = String.format("%02d", i);
            System.out.println(iFormatted + ". " + brd);
            i++;
        }

    }

    public void displayByIMDBRatingAscending(List<BluRayDisc> list) {
        System.out.println("\nHere are all the 4K BluRays in our collection, listed in order of IMDB's average user score, ascending: \n\n-------------------------\n");
        list.sort(BluRayDisc.BRDIMDBScoreAscendingComparator);
        int i = 1;
        for (BluRayDisc brd : list) {
            String iFormatted = String.format("%02d", i);
            System.out.println(iFormatted + ". " + brd);
            i++;
        }

    }

    public void displayByRuntimeDescending(List<BluRayDisc> list) {
        System.out.println("\nHere are all the 4K BluRays in our collection, listed in order of runtime in minutes, descending: \n\n-------------------------\n");
        list.sort(BluRayDisc.BRDRuntimeDescendingComparator);
        int i = 1;
        for (BluRayDisc brd : list) {
            String iFormatted = String.format("%02d", i);
            System.out.println(iFormatted + ". " + brd);
            i++;
        }
    }

    public void displayByRuntimeAscending(List<BluRayDisc> list) {
        System.out.println("\nHere are all the 4K BluRays in our collection, listed in order of runtime in minutes, ascending: \n\n-------------------------\n");
        list.sort(BluRayDisc.BRDRuntimeAscendingComparator);
        int i = 1;
        for (BluRayDisc brd : list) {
            String iFormatted = String.format("%02d", i);
            System.out.println(iFormatted + ". " + brd);
            i++;
        }
    }

    public void displayByReleaseYearDescending(List<BluRayDisc> list) {
        System.out.println("\nHere are all the 4K BluRays in our collection, listed in order of runtime in minutes, ascending: \n\n-------------------------\n");
        list.sort(BluRayDisc.BRDReleaseYearDescendingComparator);
        int i = 1;
        for (BluRayDisc brd : list) {
            String iFormatted = String.format("%02d", i);
            System.out.println(iFormatted + ". " + brd);
            i++;
        }
    }

    public void displayByReleaseYearAscending(List<BluRayDisc> list) {
        System.out.println("\nHere are all the 4K BluRays in our collection, listed in order of runtime in minutes, ascending: \n\n-------------------------\n");
        list.sort(BluRayDisc.BRDRelaseYearAscendingComparator);
        int i = 1;
        for (BluRayDisc brd : list) {
            String iFormatted = String.format("%02d", i);
            System.out.println(iFormatted + ". " + brd);
            i++;
        }
    }
}

