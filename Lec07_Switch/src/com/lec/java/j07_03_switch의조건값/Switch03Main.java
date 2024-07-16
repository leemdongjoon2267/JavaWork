package com.lec.java.j07_03_switch의조건값;

/* switch (조건) {case1:  case2:}
 *   (조건)에 따라서 해당 case로 이동
 *   (조건)에 사용될 수 있는 자료 타입은
 *    1. int로 변환 가능한 타입들: byte, short, int, char
 *    2. enum 타입(enum 자료형은 Java 5 버전부터 소개)
 *    3. String 타입 (Java 7 버전부터 switch 문에서 사용 가능)
 */
public class Switch03Main {

	public static void main(String[] args) {
		System.out.println("switch 제약 조건");
		System.out.println("char를 switch문에서 사용");

		char ch = 'C';

		switch (ch){
			case 'a' :
				System.out.println('A');
				break;

			case 'b' :
				System.out.println('B');
				break;

			case 'c' :
			case 'C' :
				System.out.println('C');
				break;

			default :
				System.out.println("몰라요~");
		}
		
		
		// switch(조건) 에 사용할수 없는 값들
//		long num = 1;
//		switch (num){}

//		switch (3.14){}


		System.out.println("String 타입을 switch에서 사용하기");

		String language = "Java";
		String result;

		switch (language){
			case "Java" :
				result = "자바";
				break;

			case "C++" :
				result = "씨뿔뿔";
				break;

			case "Python" :
				result = "파이썬";
				break;

			default :
				result = "모르는 언어";
				// default 문을 없애면 아래에서 result 값이 초기화가 되지 않아 오류
		}

		System.out.println("결과 : " + result);

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









