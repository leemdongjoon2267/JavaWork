package com.J06.LocalDateTime날짜계산;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 두개의 LocalDate 사이의 날짜 구하기

public class DateTime06Main {

	public static void main(String[] args) {

//		LocalDateTime now = LocalDateTime.now();
		LocalDateTime now = LocalDateTime.of(2024,2,13,21,39,34,12345);

		LocalDateTime[] arr = {
				now,
				now.plusDays(1),
				now.plusDays(30),
				now.plusMonths(1), // plusDays(30) 과 의미 다르다
				now.plusYears(1),
				now.plusHours(3),
				now.plusMinutes(4),
//				now.plus(10,)

				// minusXXXX() 사용법 동일
		};

		for(var date : arr) System.out.println(date);

		//----------------------------------------------
		System.out.println("-".repeat(15));
		LocalDate start = LocalDate.now();
		// 오늘 기준으로 다음달 마지막 날
		LocalDate end = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

		System.out.println(end);

	} // end main

} // end class



















