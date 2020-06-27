package com.CommandLineToDoApp;

public class Main {

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        Display display = new Display();

        display.WelcomeMessage();
        String myTasksString = null;
        try {
            myTasksString = fileHandler.readAllTasks( display.getPreviousFile("Type name of the file you would like to be loaded: "));
        } catch(NullPointerException e) {
            display.errorMessage("Does the file exists?");
        }
        display.displayMessage("Your tasks: ");
        if (myTasksString == null) {
            display.errorMessage("Perhaps you don't have any tasks in that file. Check if you typed the name correctly.");
        }
        display.displayMessage(myTasksString);
        display.askForTaskList(display.getFileName());
        display.successMessage();

        display.displayMessage("Thank you for using the program! Bye!");
        System.exit(0);
    }
}
