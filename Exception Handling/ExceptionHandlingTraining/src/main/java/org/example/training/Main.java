package org.example.training;

import org.example.training.exception.EmptyFileException;

public class Main {
    public static void main(String[] args) {
        FileReaderApp readerApp = new FileReaderApp();

        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("Enter the file name: ");
            String filename = scanner.nextLine();

            try {
                readerApp.readFile(filename);
            } catch (Exception e) {
                System.err.println("Custom Exception: " + e.getMessage());
            }

        } // scanner is automatically closed here, because of try with resource, as explained in the session.
    }
}
