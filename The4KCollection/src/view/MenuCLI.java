package view;

import com.nateshrader.main.BRList;

import java.util.Scanner;

public class MenuCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ALL = "Display All 4K Blu Rays";
    private static final String MAIN_MENU_OPTION_DISPLAY_BY_GENRE = "Display By Genre";
    private static final String MAIN_MENU_OPTION_DISPLAY_BY_MPAA_RATING = "Display By MPAA Rating";
    private static final String MAIN_MENU_OPTION_DISPLAY_NATE_UNWATCHED = "Display All Unwatched By Nate";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ALL, MAIN_MENU_OPTION_DISPLAY_BY_GENRE, MAIN_MENU_OPTION_DISPLAY_BY_MPAA_RATING, MAIN_MENU_OPTION_DISPLAY_NATE_UNWATCHED, MAIN_MENU_OPTION_EXIT};
    private static final String SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY = "Display Alphabetically";
    private static final String SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING = "Display By Top Rated On IMDB";
    private static final String SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME = "Display By Runtime";
    private static final String SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR = "Display By Release Year";
    private static final String[] SUB_MENU_1_OPTIONS = {SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY, SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING, SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME, SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR};
    private static final String SUB_MENU_2_OPTION_DRAMA = "Drama";
    private static final String SUB_MENU_2_OPTION_COMEDY = "Comedy";
    private static final String SUB_MENU_2_OPTION_HORROR = "Horror";
    private static final String SUB_MENU_2_OPTION_SCI_FI = "Sci-Fi";
    private static final String SUB_MENU_2_OPTION_ACTION = "Action";
    private static final String SUB_MENU_2_OPTION_WAR = "War";
    private static final String SUB_MENU_2_OPTION_THRILLER = "Thriller";
    private static final String SUB_MENU_2_OPTION_FANTASY = "Fantasy";
    private static final String SUB_MENU_2_OPTION_ROMANCE = "Romance";
    private static final String[] SUB_MENU_2_OPTIONS = {SUB_MENU_2_OPTION_DRAMA, SUB_MENU_2_OPTION_COMEDY, SUB_MENU_2_OPTION_HORROR, SUB_MENU_2_OPTION_SCI_FI, SUB_MENU_2_OPTION_ACTION, SUB_MENU_2_OPTION_WAR, SUB_MENU_2_OPTION_THRILLER, SUB_MENU_2_OPTION_FANTASY, SUB_MENU_2_OPTION_ROMANCE};
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

    private final Scanner userInput = new Scanner(System.in);
    private final Menu menu = new Menu(System.in, System.out);
    private final BRList bluRays = new BRList();

    public String[] getMainMenuOptions() {
        return MAIN_MENU_OPTIONS;
    }

    public String[] getSubMenu1Options() {
        return SUB_MENU_1_OPTIONS;
    }

    public String[] getSubMenu2Options() {
        return SUB_MENU_2_OPTIONS;
    }

    public String[] getSubMenu3Options() {
        return SUB_MENU_3_OPTIONS;
    }

    public String[] getSubMenu4Options() {
        return SUB_MENU_4_OPTIONS;
    }

    public String[] getAscOrDescOptions() {
        return ASC_OR_DESC_OPTIONS;
    }


    public void output(String content) {
        System.out.println(); //Print blank line
        System.out.println(content);
    }

    public void pauseOutput() {
        System.out.println("(Press enter to continue)");
        userInput.nextLine();
    }

    public String promptForSelection(String[] options) {
        return (String) menu.getChoiceFromOptions(options);
    }

    public void displayGreeting() {
        System.out.println("\nGOOD DAY!\n\nWelcome to The 4K Blu Ray Collection, where you can view information regarding every single 4K Blu Ray in Nate and Corey's collection." +
                "\nPlease make a selection from the menu items below to get started.");
    }

    public void genreSelectionOpeningText() {
        System.out.println("\nIn what order would you like to view the movies of your selected genre?");
    }

    public void mainMenuDisplayAll() {
        System.out.println("\nYou chose to list all the 4K Blu Rays in the collection. How'd you like those bad boys ordered?");
        String subSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (subSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getBluRays());
        } else if (subSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getBluRays());
            }
        } else if (subSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getBluRays());
            } else {
                bluRays.displayByRuntimeAscending(bluRays.getBluRays());
            }
        } else if (subSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getBluRays());
            }
        }
    }

    public void MainMenuDisplayByGenre() {
        System.out.println("\nYou chose to browse the collection by genre. What genre are you feelin' right now? (As a note, each movie is assigned two genres, so you may see a movie appear under 2 different genres.)");
        String subselection = promptForSelection(SUB_MENU_2_OPTIONS);
        switch (subselection) {
            case SUB_MENU_2_OPTION_DRAMA:
                DisplayByGenre("Drama");
                break;
            case SUB_MENU_2_OPTION_ACTION:
                DisplayByGenre("Action");
                break;
            case SUB_MENU_2_OPTION_COMEDY:
                DisplayByGenre("Comedy");
                break;
            case SUB_MENU_2_OPTION_HORROR:
                DisplayByGenre("Horror");
                break;
            case SUB_MENU_2_OPTION_SCI_FI:
                DisplayByGenre("Sci-Fi");
                break;
            case SUB_MENU_2_OPTION_WAR:
                DisplayByGenre("War");
                break;
            case SUB_MENU_2_OPTION_THRILLER:
                DisplayByGenre("Thriller");
                break;
            case SUB_MENU_2_OPTION_FANTASY:
                DisplayByGenre("Fantasy");
                break;
            case SUB_MENU_2_OPTION_ROMANCE:
                DisplayByGenre("Romance");
                break;
        }
    }

    public void MainMenuDisplayByMPAARating() {
        System.out.print("\n You chose to browse the selection by MPAA Rating? How spicy we feelin' right now?");
        String subSelection = promptForSelection(SUB_MENU_3_OPTIONS);
        switch (subSelection) {
            case SUB_MENU_3_OPTION_G:
                System.out.println("You chose to browse movies rated G. Honestly, there probably aren't a ton of these in our collection, but how do you want them ordered?");
                DisplayByMPAARating("G");
                break;
            case SUB_MENU_3_OPTION_PG:
                System.out.println("You chose to browse movies rated PG. Honestly, there probably aren't a ton of these in our collection, but how do you want them ordered?");
                DisplayByMPAARating("PG");
                break;
            case SUB_MENU_3_OPTION_PG13:
                System.out.println("You chose to browse movies rated PG-13. How do you want them ordered?");
                DisplayByMPAARating("PG-13");
                break;
            case SUB_MENU_3_OPTION_R:
                System.out.println("You chose to browse movies rated R. Let me see some ID, kid. Seriously, though. How do you want them ordered?");
                DisplayByMPAARating("R");
                break;
            case SUB_MENU_3_OPTION_UNRATED:
                System.out.println("You chose to browse movies that are unrated or have a rating that isn't G, PG, PG-13, or R. Honestly, there probably aren't a ton of these in our collection, but how do you want them ordered?");
                DisplayByMPAARating("Unrated");
                break;
        }
    }

    public void MainMenuDisplayUnwatchedByNate() {
        System.out.println("\nYou chose to view movies unwatched by Nate. I assume you are probably Nate. Hey, Nate! Your app is looking pretty clean, my guy.");
        bluRays.displayAlphabetically(bluRays.getBluRaysUnwatchedByNate());
    }

    public void DisplayByMPAARating(String mPAARating) {
        String gSubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (gSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getBluRaysByMPAARating(mPAARating));
        } else if (gSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getBluRaysByMPAARating(mPAARating));
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getBluRaysByMPAARating(mPAARating));
            }
        } else if (gSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getBluRaysByMPAARating(mPAARating));
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getBluRaysByMPAARating(mPAARating));
            }
        } else if (gSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getBluRaysByMPAARating(mPAARating));
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getBluRaysByMPAARating(mPAARating));
            }
        }
    }

    public void DisplayByGenre(String genre) {
        genreSelectionOpeningText();
        String dramaSubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (dramaSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getBluRaysByGenre(genre));
        } else if (dramaSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getBluRaysByGenre(genre));
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getBluRaysByGenre(genre));
            }
        } else if (dramaSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getBluRaysByGenre(genre));
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getBluRaysByGenre(genre));
            }
        } else if (dramaSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getBluRaysByGenre(genre));
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getBluRaysByGenre(genre));
            }
        }
    }
}
