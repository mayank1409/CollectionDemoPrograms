package io.javamasters.datetime.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class JavaDemoApp {

	public static void main(String[] args) {
		//// Local Date
		LocalDate date = LocalDate.now();
		System.out.println(date);

		LocalDate newDate = date.withDayOfMonth(04).withMonth(10).withYear(2022);
		System.out.println(newDate);

		/// atStartOfDay()
		System.out.println(date.atStartOfDay());

		System.out.println("day of month = " + date.getDayOfMonth());
		System.out.println("day of week = " + date.getDayOfWeek());
		System.out.println("month = " + date.getMonth() + " month value = " + date.getMonthValue());

		
		//// plus methods
		newDate = date.plusDays(10).plusMonths(2).plusYears(1);
		System.out.println(newDate);

		//// minus methods
		newDate = date.minusDays(10).minusMonths(2).minusYears(1);
		System.out.println(newDate);
		
		
		System.out.println();

		///// Local Time
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		System.out.println("Hour " + time.getHour());
		System.out.println("Minute " + time.getMinute());
		System.out.println("Second " + time.getSecond());

		///// plus methods for the LocalTime
		LocalTime newTime = time.plusHours(2).plusMinutes(34).plusSeconds(12);
		System.out.println(newTime);

		///// minus methods for the LocalTime
		newTime = time.minusHours(2).minusMinutes(34).minusSeconds(12);
		System.out.println(newTime);

		System.out.println();
		
		///// LocalDateTime
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);

		///// plus methods for the LocalDateTime
		LocalDateTime newDateTime = dateTime.plusDays(1).plusMonths(1).plusYears(1).plusHours(1).plusMinutes(1)
				.plusSeconds(1);
		System.out.println(newDateTime);

		///// minus methods for the LocalDateTime
		newDateTime = dateTime.minusDays(1).minusMonths(1).minusYears(1).minusHours(1).minusMinutes(1).minusSeconds(1);
		System.out.println(newDateTime);
		
		System.out.println();

		////////////////
		//// converting from java.util.Date to java.time.LocalDate
		Date input = new Date();
		LocalDate localDate = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		System.out.println(input + " ==> " + localDate);
		
		///// parse with formatter
		System.out.println();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// create a LocalDate object and
		LocalDate lt = LocalDate.parse("31/12/2018", formatter);

		System.out.println();
		// print result
		
		System.out.println("Parsed LocalDate : " + lt);
		
		////////// ChronoUnit
		
		LocalDate start = LocalDate.now();
		LocalDate end = start.plusDays(20);
		long daysBetween = ChronoUnit.DAYS.between(start, end);
		System.out.println("Days = " + daysBetween);
		
		
		/////// period
		
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);

		Period p = Period.between(birthday, today);
		long years = ChronoUnit.YEARS.between(birthday, today);
		
		System.out.println("You are " + p.getYears() + " old");
		System.out.println("You are " + years + " old");

		
		/// Zoned date time
		ZonedDateTime zonedDate = ZonedDateTime.now();
		System.out.println("zonedDate day of month = " + zonedDate.getDayOfMonth());
	}
}
