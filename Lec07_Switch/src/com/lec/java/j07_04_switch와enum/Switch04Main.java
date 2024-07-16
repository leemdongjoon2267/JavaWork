package com.lec.java.j07_04_switch와enum;

public class Switch04Main {

	// enum 타입 정의하는 방법: (enumeration)
	// enum 이름 {}
	// enum 타입 정의 메소드 안에서는 할 수 없다.
	
	enum Days{SUN, MON, TUE, WED, THU, FRI, SAT} // 'Days' 라는 이름의 enum 타입 정의

	public static void main(String[] args) {
		System.out.println("enum 타입을 switch에서 사용하기");
		
		Days day1 = Days.THU; // 변수 선언
		System.out.println(day1); // 문자열 타입은 아니지만 출력은 문자열 처럼 보임
		Days day2 = Days.MON;

		switch (day1){
			case SUN : // enum 타입을 사용하는 switch 에선 enum 타입명은 생략
				System.out.println("일요일");
				break;

			case MON :
			case TUE :
			case WED :
				System.out.println("주 초반");
				break;

			case THU :
			case FRI :
				System.out.println("주 후반");
				break;

			case SAT :
				System.out.println("주말");
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










