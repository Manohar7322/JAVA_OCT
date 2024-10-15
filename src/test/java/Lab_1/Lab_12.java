package Lab_1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Lab_12 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter the first date (yyyy-MM-dd): ");
        String firstDateInput = scanner.nextLine();

        System.out.print("Enter the second date (yyyy-MM-dd): ");
        String secondDateInput = scanner.nextLine();

        try {
            
            LocalDate firstDate = LocalDate.parse(firstDateInput, formatter);
            LocalDate secondDate = LocalDate.parse(secondDateInput, formatter);

            Period period = Period.between(firstDate, secondDate);

            System.out.println("Duration between " + firstDate + " and " + secondDate + ":");
            System.out.println(period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

}
