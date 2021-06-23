package com.nateshrader.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class BRList {

    public BRList() {
        createListsFromFile();
    }

    private final List<BluRayDisc> allBluRays = new ArrayList<>();
    private final List<BluRayDisc> dramaBluRays = new ArrayList<>();
    private final List<BluRayDisc> thrillerBluRays = new ArrayList<>();
    private final List<BluRayDisc> actionBluRays = new ArrayList<>();
    private final List<BluRayDisc> horrorBluRays = new ArrayList<>();
    private final List<BluRayDisc> sciFiBluRays = new ArrayList<>();
    private final List<BluRayDisc> comedyBluRays = new ArrayList<>();
    private final List<BluRayDisc> fantasyBluRays = new ArrayList<>();
    private final List<BluRayDisc> warBluRays = new ArrayList<>();
    private final List<BluRayDisc> romanceBluRays = new ArrayList<>();
    private final List<BluRayDisc> gBluRays = new ArrayList<>();
    private final List<BluRayDisc> pgBluRays = new ArrayList<>();
    private final List<BluRayDisc> pg13BluRays = new ArrayList<>();
    private final List<BluRayDisc> rBluRays = new ArrayList<>();
    private final List<BluRayDisc> unratedBluRays = new ArrayList<>();
    private final List<BluRayDisc> unwatchedByNateBluRays = new ArrayList<>();

    public List<BluRayDisc> getAllBluRays() {
        return allBluRays;
    }

    public List<BluRayDisc> getDramaBluRays() {
        return dramaBluRays;
    }

    public List<BluRayDisc> getThrillerBluRays() {
        return thrillerBluRays;
    }

    public List<BluRayDisc> getActionBluRays() {
        return actionBluRays;
    }

    public List<BluRayDisc> getHorrorBluRays() {
        return horrorBluRays;
    }

    public List<BluRayDisc> getSciFiBluRays() {
        return sciFiBluRays;
    }

    public List<BluRayDisc> getComedyBluRays() {
        return comedyBluRays;
    }

    public List<BluRayDisc> getFantasyBluRays() {
        return fantasyBluRays;
    }

    public List<BluRayDisc> getWarBluRays() {
        return warBluRays;
    }

    public List<BluRayDisc> getRomanceBluRays() {
        return romanceBluRays;
    }

    public List<BluRayDisc> getGBluRays() {
        return gBluRays;
    }

    public List<BluRayDisc> getPgBluRays() {
        return pgBluRays;
    }

    public List<BluRayDisc> getPg13BluRays() {
        return pg13BluRays;
    }

    public List<BluRayDisc> getRBluRays() {
        return rBluRays;
    }

    public List<BluRayDisc> getUnratedBluRays() {
        return unratedBluRays;
    }

    public List<BluRayDisc> getUnwatchedByNateBluRays() {
        return unwatchedByNateBluRays;
    }

    private void createListsFromFile() {
        File bluraysfile = new File("blurays.txt");

        try (Scanner fileScanner = new Scanner(bluraysfile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] segmentsOfFile = line.split("\\|");
                BluRayDisc brd = new BluRayDisc(Integer.parseInt(segmentsOfFile[0]), segmentsOfFile[1], Integer.parseInt(segmentsOfFile[2]), segmentsOfFile[3], Integer.parseInt(segmentsOfFile[4]), segmentsOfFile[5], segmentsOfFile[6], BigDecimal.valueOf(Double.parseDouble(segmentsOfFile[7])), Boolean.parseBoolean(segmentsOfFile[8]),
                        segmentsOfFile[9], segmentsOfFile[10]);
                allBluRays.add(brd);
                if (segmentsOfFile[9].equals("Drama") || segmentsOfFile[10].equals("Drama")) dramaBluRays.add(brd);
                if (segmentsOfFile[9].equals("Comedy") || segmentsOfFile[10].equals("Comedy")) comedyBluRays.add(brd);
                if (segmentsOfFile[9].equals("Horror") || segmentsOfFile[10].equals("Horror")) horrorBluRays.add(brd);
                if (segmentsOfFile[9].equals("Sci-Fi") || segmentsOfFile[10].equals("Sci-Fi")) sciFiBluRays.add(brd);
                if (segmentsOfFile[9].equals("Action") || segmentsOfFile[10].equals("Action")) actionBluRays.add(brd);
                if (segmentsOfFile[9].equals("War") || segmentsOfFile[10].equals("War")) warBluRays.add(brd);
                if (segmentsOfFile[9].equals("Thriller") || segmentsOfFile[10].equals("Thriller")) thrillerBluRays.add(brd);
                if (segmentsOfFile[9].equals("Fantasy") || segmentsOfFile[10].equals("Fantasy")) fantasyBluRays.add(brd);
                if (segmentsOfFile[9].equals("Romance") || segmentsOfFile[10].equals("Romance")) romanceBluRays.add(brd);
                if (segmentsOfFile[3].equals("G")) gBluRays.add(brd);
                if (segmentsOfFile[3].equals("PG")) pgBluRays.add(brd);
                if (segmentsOfFile[3].equals("PG-13")) pg13BluRays.add(brd);
                if (segmentsOfFile[3].equals("R")) rBluRays.add(brd);
                if (segmentsOfFile[3].equals("Unrated") || segmentsOfFile[3].equals("TV-MA")) unratedBluRays.add(brd);
                if (segmentsOfFile[8].equals("false")) unwatchedByNateBluRays.add(brd);
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

