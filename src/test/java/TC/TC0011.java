package TC;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class TC0011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Instant CurrentTime=Instant.now();
		//DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		LocalDate now =LocalDate.now();
		
		System.out.println("current time is:"+CurrentTime);
		System.out.println("Today:"+now);
		System.out.println("tommorow:"+now.plusDays(1));
		System.out.println("yesterday:"+now.minusDays(1));
		System.out.println("Last month:"+now.minusMonths(1));
		System.out.println("Is leap:"+now.isLeapYear());
		System.out.println("move 30th day of the month:"+now.withDayOfMonth(30));
		ZonedDateTime CT =ZonedDateTime.now();
		ZonedDateTime CT_paris=ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println("current time:"+CT);
		System.out.println("paris time:"+CT_paris);
		System.out.println("tommorow_paris:"+CT_paris.plusDays(1));
		System.out.println("yesterday_paris:"+CT_paris.minusDays(1));
		System.out.println("Last month_paris:"+CT_paris.minusMonths(1));
		//System.out.println("Is leap:"+now.isLeapYear());
		System.out.println("move 30th day of the month_paris:"+CT_paris.withDayOfMonth(30));
		ZonedDateTime CT_Aus=ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
		System.out.println("AUS time:"+CT_Aus);
		
		LocalDate start=LocalDate.of(2024, Month.SEPTEMBER , 23);
		LocalDate end=LocalDate.now();
		Period period=start.until(end);
		System.out.println("Days:"+period.get(ChronoUnit.DAYS));
		System.out.println("months:"+period.get(ChronoUnit.MONTHS));
		System.out.println("years:"+period.get(ChronoUnit.YEARS));
		

	}

}
