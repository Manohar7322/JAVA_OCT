package Lab_1;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Lab_14 {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter a time zone ID (e.g., America/New_York, Europe/London): ");
	        String timeZoneId = scanner.nextLine();

	        printCurrentDateTimeInZone(timeZoneId);

	        scanner.close();
	    }

	    public static void printCurrentDateTimeInZone(String timeZoneId) {
	        try {

	            ZoneId zoneId = ZoneId.of(timeZoneId);
	            ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);

	            System.out.println("Current date and time in " + timeZoneId + ": " + zonedDateTime);
	        } catch (Exception e) {
	            System.out.println("Invalid time zone ID. Please enter a valid zone (e.g., America/New_York).");
	        }
	    }

}
