package com.nateshrader.main;

import view.MenuCLI;

public class Application {


    private final MenuCLI ui = new MenuCLI();
    private BRList collection = new BRList();

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        ui.displayGreeting();
        while (true) {
            System.out.println("\n---------\nMAIN MENU\n---------");
            String selection = ui.promptForSelection(ui.getMainMenuOptions());
            if (selection.equals(ui.getMainMenuOptions()[0])) {
                ui.mainMenuDisplayAll();
            } else if (selection.equals(ui.getMainMenuOptions()[1])) {
                ui.MainMenuDisplayByGenre();
            } else if (selection.equals(ui.getMainMenuOptions()[2])) {
                ui.MainMenuDisplayByMPAARating();
            } else if (selection.equals(ui.getMainMenuOptions()[3])) {
                ui.MainMenuDisplayUnwatchedByNate();
            }
        }
    }
}


