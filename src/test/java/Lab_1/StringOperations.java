package Lab_1;

import java.util.HashSet;
import java.util.Scanner;
 
public class StringOperations {
    public static String performOperation(String input, int choice) {
        switch (choice) {
            case 1: // Add the String to itself
                return input + input;
            case 2: // Replace odd positions with '#'
                return replaceOddPositions(input);
            case 3: // Remove duplicate characters
                return removeDuplicates(input);
            case 4: // Change odd characters to upper case
                return changeOddCharsToUpper(input);
            default:
                return "Invalid choice!";
        }
    }
 
    private static String replaceOddPositions(String input) {
        StringBuilder result = new StringBuilder(input);
        for (int i = 1; i < result.length(); i += 2) {
            result.setCharAt(i, '#');
        }
        return result.toString();
    }
 
    private static String removeDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                result.append(c);
            }
        }
        return result.toString();
    }
 
    private static String changeOddCharsToUpper(String input) {
        StringBuilder result = new StringBuilder(input);
        for (int i = 0; i < result.length(); i += 2) {
            result.setCharAt(i, Character.toUpperCase(result.charAt(i)));
        }
        return result.toString();
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        System.out.println("Choose an operation:\n1. Add the String to itself\n2. Replace odd positions with #\n3. Remove duplicate characters\n4. Change odd characters to upper case");
        int choice = scanner.nextInt();
 
        String result = performOperation(input, choice);
        System.out.println("Result: " + result);
    }
}

