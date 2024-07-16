package com.J04.LocalDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
 * java.time 패키지
 * 	- JAVA8 부터 도입
 * 	- 날짜 + 시간을 '조작' '비교' 등을 하는 기능을 추가한 객체들
 *  
 *  날짜와 시간을 표현하는 클래스들
 *  LocalDate	로컬 날짜 클래스 
 *  LocalTime	로클 시간 클래스
 *  LocalDateTime  로컬 날짜 및 시간클래스 (LocalDate + LocalTime)
 *  
 *  https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html
 *  
 *  
 *  ★이제 가급적 java.time 객체를 사용하자!  구 Date, Calendar 의 문제점!★
 *  
 *  - Date 클래스: time zone 기능 없슴.. format 기능 없슴.. calendar 기능 없슴.
 *   	특정 시점의 날짜 정보 '저장'정도 밖에 못함. 대부분 메소드는 deprecated 됨
 *   
 *	- Calendar 클래스 :  날짜, 시간에 대해 '조작', '비교' 하는 기능이 불충분
 *		월 month 값 설계 오류.  Calendar.OCTOBER 가 9 --> 혼란 야기
 *
 *	- Date, Calendar 둘다 immutable 이 아님 (mutable) 임.
 *		--> 멀티쓰레드 환경에서 언제든 문제 발생 가능.
 *	
 *	- 결정적으로 나중에 스프링, 웹어플리케이션등 제작에서 java.time 을 사용하는 것이 훨씬 수월해진다.
 *	  LocalDate 와 LocalDateTime 이 데이터베이스에 제대로 매핑이 되지 않는 이슈도 Hibernate 5.2.10 버젼에서 해결.   (스프링부트 2.x 버젼에서는 해당버젼 사용중)
 *    MyBatis 3.4.5 부터도 매핑 지원 내장됨. https://mybatis.org/mybatis-3/ko/configuration.html#typeAliases
 *
 *  - 참조 : https://d2.naver.com/helloworld/645609
 */
public class DateTime04Main {

	public static void main(String[] args) {
		System.out.println("-- java.time --");

		LocalDate date1, date2; // 날짜
		LocalTime time1, time2; // 시간
		LocalDateTime datetime1, datetime2; // 날짜, 시간
		String myDate = "2023-04-05";

		// Object 라는 최상위 객체를 써서 어떤 형태의 배열이라고 다 가능함
		Object[] arr = {
				"\n[LocalDate]",
				"현재날짜: " + (date1 = LocalDate.now()),   // now() 현재 날짜  2023-09-22

				// of(year, month, dayOfMonth) 주어진 날짜
				"주어진날짜: " + LocalDate.of(1994, 4, 20),  // 1999-04-20

				"\n[LocalTime]",
				"현재시간: " + LocalTime.now(),   // 00:13:38.993207500

				// of(hour, minute, second, nanoOfSecond) 주어진 시간
				"주어진시간: " + LocalTime.of(23,12,22,123456),  // 23:12:22.001234567

				"\n[LocalDateTime]",
				"현재날짜시간: " + LocalDateTime.now(),  // 2023-09-21T14:43:15.685732500
				"주어진날짜시간: "  + LocalDateTime.of(2024,4,8,14,26,23,123456),

				// LocalDateTime => String
				"\n[LocalDateTime → String] format(), DateTimeFormatter 사용",
				// java.time.DateTimeFormatter 를 사용하여 원하는 포맷으로 출력
				// https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
				datetime1 = LocalDateTime.now(),
				datetime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
				// 년 월 일 시 분 초 대소문자 구별 필수
				datetime1.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초")), // 24시간 체계
				datetime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd일 hh:mm:ss")), // 12시간 체계
				datetime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd일 a hh:mm:ss")), // 오전 오후 구별

				// String -> LocalDate
				"\n[String → LocalDate ] LocalDate.parse(), DateTimeFormatter 사용",
				// LocalDate 객체
				LocalDate.parse("2024-04-08", DateTimeFormatter.ofPattern("yyyy-MM-dd"))
		};
		for (var d : arr) System.out.println(d);
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

















