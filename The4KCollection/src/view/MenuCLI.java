package view;

import java.util.Scanner;

public class MenuCLI {

    private final Scanner userInput = new Scanner(System.in);
    private final Menu menu = new Menu(System.in, System.out);

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

    public void mainMenuOption1Output() {
        System.out.println("\nYou chose to list all the 4K Blu Rays in the collection. How'd you like those bad boys sorted?");
    }

    public void mainMenuOption2Output() {
        System.out.println("\nYou chose to browse the collection by genre. What genre are you feelin' right now?");
    }

    public void genreSelectionOutput() {
        System.out.println("\nIn what order would you like to view the movies of your selected genre?");
    }

}
