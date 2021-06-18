package com.nateshrader.main;

import view.MenuCLI;

public class Application {

    private static final String MAIN_MENU_OPTION_DISPLAY_ALL = "Display All 4K Blu Rays";
    private static final String MAIN_MENU_OPTION_DISPLAY_BY_GENRE = "Display By Genre";
    private static final String MAIN_MENU_OPTION_DISPLAY_BY_MPAA_RATING = "Display By MPAA Rating";
    private static final String MAIN_MENU_OPTION_DISPLAY_NATE_UNWATCHED = "Display All Unwatched By Nate";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ALL, MAIN_MENU_OPTION_DISPLAY_BY_GENRE, MAIN_MENU_OPTION_DISPLAY_BY_MPAA_RATING, MAIN_MENU_OPTION_DISPLAY_NATE_UNWATCHED};
    private static final String SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY = "Display Alphabetically";
    private static final String SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING = "Display By Top Rated On IMDB";
    private static final String SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME = "Display By Runtime";
    private static final String SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR = "Display By Release Year";
    private static final String[] SUB_MENU_1_OPTIONS = {SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY, SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING, SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME, SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR};
    private static final String SUB_MENU_2_OPTION_DRAMA = "Drama";
    private static final String SUB_MENU_2_OPTION_COMEDY = "Comedy";
    private static final String SUB_MENU_2_OPTION_THRILLER_HORROR = "Horror";
    private static final String SUB_MENU_2_OPTION_SCI_FI = "Sci-Fi";
    private static final String SUB_MENU_2_OPTION_ACTION = "Action";
    private static final String SUB_MENU_2_OPTION_WAR = "War";
    private static final String SUB_MENU_2_OPTION_THRILLER = "Thriller";
    private static final String SUB_MENU_2_OPTION_FANTASY = "Fantasy";
    private static final String SUB_MENU_2_OPTION_ROMANCE= "Romance";
    private static final String[] SUB_MENU_2_OPTIONS = {SUB_MENU_2_OPTION_DRAMA, SUB_MENU_2_OPTION_COMEDY, SUB_MENU_2_OPTION_THRILLER_HORROR, SUB_MENU_2_OPTION_SCI_FI, SUB_MENU_2_OPTION_ACTION, SUB_MENU_2_OPTION_WAR, SUB_MENU_2_OPTION_THRILLER, SUB_MENU_2_OPTION_FANTASY, SUB_MENU_2_OPTION_ROMANCE};
    private static final String SUB_MENU_3_OPTION_G = "G";
    private static final String SUB_MENU_3_OPTION_PG = "PG";
    private static final String SUB_MENU_3_OPTION_PG13 = "PG-13";
    private static final String SUB_MENU_3_OPTION_R = "R";
    private static final String SUB_MENU_3_OPTION_UNRATED = "Unrated";
    private static final String[] SUB_MENU_3_OPTIONS = {SUB_MENU_3_OPTION_G, SUB_MENU_3_OPTION_PG, SUB_MENU_3_OPTION_PG13, SUB_MENU_3_OPTION_R, SUB_MENU_3_OPTION_UNRATED};
    private static final String SUB_MENU_4_OPTION_UNDER_100_MIN = "Display All Under 100 Minutes";
    private static final String SUB_MENU_4_OPTION_UNDER_2_HOURS = "Display All 2 Hours Or Shorter";
    private static final String SUB_MENU_4_OPTION_UNDER_2_AND_HALF_HOURS = "Display All 2.5 Hours Or Shorter";
    private static final String SUB_MENU_4_OPTION_LONGER_THAN_2_AND_HALF_HOURS = "Display All Epics Longer Than 2.5 Hours";
    private static final String[] SUB_MENU_4_OPTIONS = {SUB_MENU_4_OPTION_UNDER_100_MIN, SUB_MENU_4_OPTION_UNDER_2_HOURS, SUB_MENU_4_OPTION_UNDER_2_AND_HALF_HOURS, SUB_MENU_4_OPTION_LONGER_THAN_2_AND_HALF_HOURS};
    private static final String OPTION_DESC = "Sort in descending order";
    private static final String OPTION_ASC = "Sort in ascending order";
    private static final String[] ASC_OR_DESC_OPTIONS = {OPTION_DESC, OPTION_ASC};

    private final MenuCLI ui = new MenuCLI();
    private BRList collection = new BRList();

    public static void main(String[] args) {
	Application application = new Application();
	application.run();
    }

    public void run() {
        ui.displayGreeting();
        while(true) {
            System.out.println("\n---------\nMAIN MENU\n---------");
            String selection = ui.promptForSelection(MAIN_MENU_OPTIONS);
            if (selection.equals(MAIN_MENU_OPTION_DISPLAY_ALL)) {
                ui.mainMenuOption1Output();
                // Display sub menu 1
                String sub1Selection = ui.promptForSelection(SUB_MENU_1_OPTIONS);
                if (sub1Selection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
                    collection.displayAlphabetically(collection.getAllBluRays());
                } else if (sub1Selection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
                    String orderSelection = ui.promptForSelection(ASC_OR_DESC_OPTIONS);
                    if (orderSelection.equals(OPTION_DESC)) {
                        collection.displayByIMDBRatingDescending(collection.getAllBluRays());
                    } else {
                        collection.displayByIMDBRatingAscending(collection.getAllBluRays());
                    }
                } else if (sub1Selection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
                    String orderSelection = ui.promptForSelection(ASC_OR_DESC_OPTIONS);
                    if (orderSelection.equals(OPTION_DESC)) {
                        collection.displayByRuntimeDescending(collection.getAllBluRays());
                    } else {
                        collection.displayByRuntimeAscending(collection.getAllBluRays());
                    }
                } else if (sub1Selection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
                    String orderSelection = ui.promptForSelection(ASC_OR_DESC_OPTIONS);
                    if (orderSelection.equals(OPTION_DESC)) {
                        collection.displayByReleaseYearDescending(collection.getAllBluRays());
                    } else {
                        collection.displayByReleaseYearAscending(collection.getAllBluRays());
                    }
                }
            } else if (selection.equals(MAIN_MENU_OPTION_DISPLAY_BY_GENRE)) {
                ui.mainMenuOption2Output();
                String sub2selection = ui.promptForSelection(SUB_MENU_2_OPTIONS);
                if (sub2selection.equals(SUB_MENU_2_OPTION_DRAMA)) {
                    ui.genreSelectionOutput();
                    String dramaSubSelection = ui.promptForSelection(SUB_MENU_1_OPTIONS);
                    if (dramaSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
                        collection.displayAlphabetically(collection.getDramaBluRays());
                    } else if (dramaSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
                        String orderSelection = ui.promptForSelection(ASC_OR_DESC_OPTIONS);
                        if (orderSelection.equals(OPTION_DESC)) {
                            collection.displayByIMDBRatingDescending(collection.getDramaBluRays());
                        } else {
                            collection.displayByIMDBRatingAscending(collection.getDramaBluRays());
                        }
                    } else if (dramaSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)){
                        String orderSelection = ui.promptForSelection(ASC_OR_DESC_OPTIONS);
                        if (orderSelection.equals(OPTION_DESC)) {
                            collection.displayByRuntimeDescending(collection.getDramaBluRays());
                        } else {
                            collection.displayByReleaseYearAscending(collection.getDramaBluRays());
                        }
                    } else if (dramaSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
                        String orderSelection = ui.promptForSelection(ASC_OR_DESC_OPTIONS);
                        if (orderSelection.equals(OPTION_DESC)) {
                            collection.displayByReleaseYearDescending(collection.getDramaBluRays());
                        } else {
                            collection.displayByReleaseYearAscending(collection.getDramaBluRays());
                        }
                    }
                }
            }
        }
    }
}
