package com.apresentacao.java.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class Dates {

	@Test
	public void teste() {
		DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("hh:mm:ss");

		System.out.println(LocalDateTime.now() + " >> " + formatterDateTime.format(LocalDateTime.now()));
		System.out.println(LocalDate.now() + " >> " + formatterDate.format(LocalDate.now()));
		System.out.println(LocalTime.now() + " >> " + formatterTime.format(LocalTime.now()));

		LocalDateTime yesterday = LocalDateTime.of(2016, Month.MARCH, 19, 18, 01, 39);
		LocalDateTime today = LocalDateTime.now();

		Period between = Period.between(yesterday.toLocalDate(), today.toLocalDate());

		System.out.println("Dia > " + between.getDays());
		System.out.println("Hora > " + today.getHour());

		System.out.println("Ano e mês > " + YearMonth.now());
		System.out.println("Ano > " + Year.now());
		System.out.println("Mês e dia > " + MonthDay.now());

	}
}
