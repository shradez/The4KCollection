package view;

import com.nateshrader.main.BRList;

import java.util.Scanner;

public class MenuCLI {

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
            bluRays.displayAlphabetically(bluRays.getAllBluRays());
        } else if (subSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getAllBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getAllBluRays());
            }
        } else if (subSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getAllBluRays());
            } else {
                bluRays.displayByRuntimeAscending(bluRays.getAllBluRays());
            }
        } else if (subSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getAllBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getAllBluRays());
            }
        }
    }

    public void MainMenuDisplayByGenre() {
        System.out.println("\nYou chose to browse the collection by genre. What genre are you feelin' right now? (As a note, each movie is assigned two genres, so you may see a movie appear under 2 different genres.)");
        String subselection = promptForSelection(SUB_MENU_2_OPTIONS);
        switch (subselection) {
            case SUB_MENU_2_OPTION_DRAMA:
                DisplayByGenreDrama();
                break;
            case SUB_MENU_2_OPTION_ACTION:
                DisplayByGenreAction();
                break;
            case SUB_MENU_2_OPTION_COMEDY:
                DisplayByGenreComedy();
                break;
            case SUB_MENU_2_OPTION_HORROR:
                DisplayByGenreHorror();
                break;
            case SUB_MENU_2_OPTION_SCI_FI:
                DisplayByGenreSciFi();
                break;
            case SUB_MENU_2_OPTION_WAR:
                DisplayByGenreWar();
                break;
            case SUB_MENU_2_OPTION_THRILLER:
                DisplayByGenreThriller();
                break;
            case SUB_MENU_2_OPTION_FANTASY:
                DisplayByGenreFantasy();
                break;
            case SUB_MENU_2_OPTION_ROMANCE:
                DisplayByGenreRomance();
                break;
        }
    }

    public void MainMenuDisplayByMPAARating() {
        System.out.print("\n You chose to browse the selection by MPAA Rating? How spicy we feelin' right now?");
        String subSelection = promptForSelection(SUB_MENU_3_OPTIONS);
        switch (subSelection) {
            case SUB_MENU_3_OPTION_G:
                DisplayByMPAARatingG();
                break;
            case SUB_MENU_3_OPTION_PG:
                DisplayByMPAARatingPG();
                break;
            case SUB_MENU_3_OPTION_PG13:
                DisplayByMPAARatingPG13();
                break;
            case SUB_MENU_3_OPTION_R:
                DisplayByMPAARatingR();
                break;
            case SUB_MENU_3_OPTION_UNRATED:
                DisplayByMPAARatingUnrated();
                break;
        }
    }

    public void MainMenuDisplayUnwatchedByNate() {
        System.out.println("\nYou chose to view movies unwatched by Nate. I assume you are probably Nate. Hey, Nate! Your app is looking pretty clean, my guy.");
        bluRays.displayAlphabetically(bluRays.getUnwatchedByNateBluRays());
    }

    public void DisplayByMPAARatingG() {
        System.out.println("You chose to browse movies rated G. Honestly, there probably aren't a ton of these in our collection, but how do you want them ordered?");
        String gSubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (gSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getGBluRays());
        } else if (gSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getGBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getGBluRays());
            }
        } else if (gSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getGBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getGBluRays());
            }
        } else if (gSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getGBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getGBluRays());
            }
        }
    }

    public void DisplayByMPAARatingPG() {
        System.out.println("You chose to browse movies rated PG. Honestly, there probably aren't a ton of these in our collection, but how do you want them ordered?");
        String pgSubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (pgSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getPgBluRays());
        } else if (pgSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getPgBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getPgBluRays());
            }
        } else if (pgSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getPgBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getPgBluRays());
            }
        } else if (pgSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getPgBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getPgBluRays());
            }
        }
    }

    public void DisplayByMPAARatingPG13() {
        System.out.println("You chose to browse movies rated PG-13. How do you want them ordered?");
        String pg13SubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (pg13SubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getPg13BluRays());
        } else if (pg13SubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getPg13BluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getPg13BluRays());
            }
        } else if (pg13SubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getPg13BluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getPg13BluRays());
            }
        } else if (pg13SubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getPg13BluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getPg13BluRays());
            }
        }
    }

    public void DisplayByMPAARatingR() {
        System.out.println("You chose to browse movies rated R. Let me see some ID, kid. Seriously, though. How do you want them ordered?");
        String rSubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (rSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getRBluRays());
        } else if (rSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getRBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getRBluRays());
            }
        } else if (rSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getRBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getRBluRays());
            }
        } else if (rSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getRBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getRBluRays());
            }
        }
    }

    public void DisplayByMPAARatingUnrated() {
        System.out.println("You chose to browse movies that are unrated or have a rating that isn't G, PG, PG-13, or R. Honestly, there probably aren't a ton of these in our collection, but how do you want them ordered?");
        String uSubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (uSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getUnratedBluRays());
        } else if (uSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getUnratedBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getUnratedBluRays());
            }
        } else if (uSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getUnratedBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getUnratedBluRays());
            }
        } else if (uSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getUnratedBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getUnratedBluRays());
            }
        }
    }

    public void DisplayByGenreDrama() {
        genreSelectionOpeningText();
        String dramaSubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (dramaSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getDramaBluRays());
        } else if (dramaSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getDramaBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getDramaBluRays());
            }
        } else if (dramaSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getDramaBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getDramaBluRays());
            }
        } else if (dramaSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getDramaBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getDramaBluRays());
            }
        }
    }

    public void DisplayByGenreAction() {
        genreSelectionOpeningText();
        String actionSubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (actionSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getActionBluRays());
        } else if (actionSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getActionBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getActionBluRays());
            }
        } else if (actionSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getActionBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getActionBluRays());
            }
        } else if (actionSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getActionBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getActionBluRays());
            }
        }
    }

    public void DisplayByGenreComedy() {
        genreSelectionOpeningText();
        String comedySubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (comedySubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getComedyBluRays());
        } else if (comedySubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getComedyBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getComedyBluRays());
            }
        } else if (comedySubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getComedyBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getComedyBluRays());
            }
        } else if (comedySubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getComedyBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getComedyBluRays());
            }
        }
    }

    public void DisplayByGenreHorror() {
        genreSelectionOpeningText();
        String horrorSubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (horrorSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getHorrorBluRays());
        } else if (horrorSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getHorrorBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getHorrorBluRays());
            }
        } else if (horrorSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getHorrorBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getHorrorBluRays());
            }
        } else if (horrorSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getHorrorBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getHorrorBluRays());
            }
        }
    }

    public void DisplayByGenreSciFi() {
        genreSelectionOpeningText();
        String sciFiSubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (sciFiSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getSciFiBluRays());
        } else if (sciFiSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getSciFiBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getSciFiBluRays());
            }
        } else if (sciFiSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getSciFiBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getSciFiBluRays());
            }
        } else if (sciFiSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getSciFiBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getSciFiBluRays());
            }
        }
    }

    public void DisplayByGenreWar() {
        genreSelectionOpeningText();
        String warSubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (warSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getWarBluRays());
        } else if (warSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getWarBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getWarBluRays());
            }
        } else if (warSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getWarBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getWarBluRays());
            }
        } else if (warSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getWarBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getWarBluRays());
            }
        }
    }

    public void DisplayByGenreThriller() {
        genreSelectionOpeningText();
        String thrillerSubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (thrillerSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getThrillerBluRays());
        } else if (thrillerSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getThrillerBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getThrillerBluRays());
            }
        } else if (thrillerSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getThrillerBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getThrillerBluRays());
            }
        } else if (thrillerSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getThrillerBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getThrillerBluRays());
            }
        }
    }

    public void DisplayByGenreFantasy() {
        genreSelectionOpeningText();
        String fantasySubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (fantasySubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getDramaBluRays());
        } else if (fantasySubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getFantasyBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getFantasyBluRays());
            }
        } else if (fantasySubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getFantasyBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getFantasyBluRays());
            }
        } else if (fantasySubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getFantasyBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getFantasyBluRays());
            }
        }
    }

    public void DisplayByGenreRomance() {
        genreSelectionOpeningText();
        String romanceSubSelection = promptForSelection(SUB_MENU_1_OPTIONS);
        if (romanceSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_ALPHABETICALLY)) {
            bluRays.displayAlphabetically(bluRays.getRomanceBluRays());
        } else if (romanceSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_IMDB_RATING)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByIMDBRatingDescending(bluRays.getRomanceBluRays());
            } else {
                bluRays.displayByIMDBRatingAscending(bluRays.getRomanceBluRays());
            }
        } else if (romanceSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RUNTIME)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByRuntimeDescending(bluRays.getRomanceBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getRomanceBluRays());
            }
        } else if (romanceSubSelection.equals(SUB_MENU_1_OPTION_DISPLAY_BY_RELEASE_YEAR)) {
            String orderSelection = promptForSelection(ASC_OR_DESC_OPTIONS);
            if (orderSelection.equals(OPTION_DESC)) {
                bluRays.displayByReleaseYearDescending(bluRays.getRomanceBluRays());
            } else {
                bluRays.displayByReleaseYearAscending(bluRays.getRomanceBluRays());
            }
        }
    }
}
