package Lab_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Lab_13 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter the product purchase date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();

        try {
            LocalDate purchaseDate = LocalDate.parse(inputDate, formatter);

            System.out.print("Enter warranty period in years: ");
            int warrantyYears = scanner.nextInt();
            System.out.print("Enter warranty period in months: ");
            int warrantyMonths = scanner.nextInt();

            LocalDate expirationDate = calculateWarrantyExpiration(purchaseDate, warrantyYears, warrantyMonths);
            System.out.println("Warranty expiration date: " + expirationDate);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static LocalDate calculateWarrantyExpiration(LocalDate purchaseDate, int years, int months) {
        return purchaseDate.plusYears(years).plusMonths(months);
    }

}
