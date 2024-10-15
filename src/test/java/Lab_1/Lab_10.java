package Lab_1;

import java.util.Scanner;

public class Lab_10 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check if it's a positive string: ");
        String inputString = scanner.nextLine();

        if (isPositiveString(inputString)) {
            System.out.println(inputString + " is a positive string.");
        } else {
            System.out.println(inputString + " is not a positive string.");
        }

        scanner.close();
    }

    public static boolean isPositiveString(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) <= str.charAt(i - 1)) {
                return false;
            }
        }
        
        return true;
    }

}
