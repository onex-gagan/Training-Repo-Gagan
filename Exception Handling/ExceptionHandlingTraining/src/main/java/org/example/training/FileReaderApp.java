package org.example.training;

import org.example.training.exception.EmptyFileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderApp {

    public void readFile(String filename) throws EmptyFileException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();

            if (line == null) {
                throw new EmptyFileException("File is empty: " + filename);
            }

            int lineNumber = 1;
            System.out.println("Results:");

            do {
                System.out.print("Line " + lineNumber + ": ");
                evaluate(line);
                line = reader.readLine();
                lineNumber++;
            } while (line != null);

        } catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
        } finally {
            System.out.println("Finished processing file.");
        }
    }

    private void evaluate(String expression) {
        try {
            String[] parts = expression.trim().split("\\s+");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid format. Expected format: <number> <operator> <number>");
            }

            double num1 = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double num2 = Double.parseDouble(parts[2]);

            double result;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported operator: " + operator);
            }

            System.out.println(expression + " = " + result);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format → " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
