package com.J05.Timestamp;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/*
 * java.sql.Timestamp;
 * 1970.01.01 00:00:00  GMT 기준 의 경과 시간을 ms (정수)로 계산해 담은 객체
 */

/**
 * 시간, 날짜 객체 다룰때
 *   java.time.*  ↔ String ↔ Timestamp 간의 데이터 변환 작업은 빈번히 발생한다.
 *   관련 변환 메소드들을 잘 활용하세요
 */

public class DateTime05Main {

	public static void main(String[] args) {
		System.out.println("java.sql.Timestamp");
		Timestamp t;

		System.out.println("Timestamp(0)");
		t = new Timestamp(0L);
		System.out.println(t);

		System.out.println("Timestamp(현재ms)");
		System.out.println(System.currentTimeMillis()); // 현재 timestamp 값
		
		
		
		//----------------------------------------------
		// 문자열 -> Timestamp
		// 	방법1 : 정해진 형식 +  Timestamp.valueOf()
		System.out.println("String -> Timestamp");
		String now = "2009-03-20 10:20:30.0";
		t = Timestamp.valueOf(now);
		System.out.println(t);
		
		
		// 	방법2 : String -> Date -> Timestamp 
		Date parseDate;

		// SimpleDateFormat 객체
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        try {
            parseDate = dateFormat.parse(now); // Date <- String
			t = new Timestamp(parseDate.getTime());
			System.out.println(t);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        //----------------------------------------------
		// Timestamp -> 문자열
		// SimpleDateFormat + Timestamp:getTime()
		String str = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(t.getTime());
		// 현재 시간을 문자열로 변환시킴
		System.out.println(str);

		// Timestamp -> LocalDateTime(자바)
		LocalDateTime dateTime = t.toLocalDateTime();
		System.out.println(dateTime);


		// LocalDateTime -> Timestamp
		t = Timestamp.valueOf(dateTime);
		System.out.println(t);

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
