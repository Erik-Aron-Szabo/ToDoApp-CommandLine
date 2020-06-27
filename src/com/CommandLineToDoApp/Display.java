package com.CommandLineToDoApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {
    //Displays welcome message for user
    public void WelcomeMessage() {
        System.out.println("Welcome to Simple Task App!");
        System.out.println("type 'exit' to quit.");
    }

    public void askForTaskList(String fileName) {
        ArrayList<String> taskList = new ArrayList<String>();
        FileHandler fileHandler = new FileHandler();
        Scanner scanner = new Scanner(System.in);
        Integer counter = 0;
        while (true) {
            if (counter == 0) {
                System.out.println("Please write your task(s):");
                counter++;
            }
            String task = scanner.nextLine();
            if (task.equals(" ") || task.isEmpty()) {
                String errorMsg = "You can not save empty tasks!!";
                errorMessage(errorMsg);
                continue;
            }
            if (task.equals("exit")) {
                break;
            }
            fileHandler.writeTaskFile(task, fileName);
        }
    }

    public String getFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the name of the file, " +
                "where you would like to save your tasks.");
        String fileName = scanner.nextLine();
        if (fileName.equals("exit")){ System.exit(0);}
        return fileName;
    }

    public void successMessage() {
        System.out.println("Saved.");
    }

    public String getPreviousFile(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String fileName = scanner.nextLine();
        if (fileName.equals("exit")){ System.exit(0);}
        return fileName;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void errorMessage(String error) {
        System.out.println(error);
    }
}
