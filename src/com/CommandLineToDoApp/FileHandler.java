package com.CommandLineToDoApp;

import java.io.*;
import java.util.stream.Collectors;

public class FileHandler {
    //Write Task to .txt file
    public void writeTaskFile(String task, String fileName) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, true);
            PrintWriter printWriter = new PrintWriter(writer, true);
            printWriter.printf(task +"\n");
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //copied from: https://www.baeldung.com/java-buffered-reader
    public String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        String row;
        while ((row = reader.readLine()) != null) {
            fileContent.append(row);
            fileContent.append(System.lineSeparator());
        }
        return fileContent.toString();
    }

    // chiefly from: https://www.baeldung.com/java-buffered-reader
    // returns a long string with \r\n
    public String readAllTasks(String fileName)  {
        BufferedReader reader= null;
        try {
             reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }

    public FileHandler() {
    }
}
