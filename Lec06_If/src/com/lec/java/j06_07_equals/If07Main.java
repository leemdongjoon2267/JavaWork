package com.lec.java.j06_07_equals;

/* String 비교, char 비교
 * - 문자열 비교는 절대로 == 를 사용하지 말자
 * - 문자열 비교는 equals(), equalsIgnoreCase() 사용!
 * 
 * - char 는 기본적으로 정수값 (아스키 코드값) 이라 일반 산술 비교 가능 
 */

public class If07Main {

	public static void main(String[] args) {
		System.out.println("String 비교, char 비교");

		{
			String name1 = "john";
			String name2 = "john";

			System.out.println(name1 == name2); // true
		}
		
		// 문자열 비교는 절대로 == 를 사용하지 말자
		{
			String name1 = "john";
			String name2 = "jo";
			name2 += "hn"; // name2 = name2 + "hn

			System.out.println(name1);
			System.out.println(name2);

			System.out.println(name1 == name2); // false
		}
		
		
		// 문자열 비교는 equals() 사용!
		{
			String name1 = "john";
			String name2 = "jo";
			name2 += "hn"; // name2 = name2 + "hn

			System.out.println(name1);
			System.out.println(name2);

			System.out.println(name1.equals(name2)); // true

			System.out.println("John".equals("john")); // false
			System.out.println("John".equalsIgnoreCase("john")); // true (문자 그대로 대소문자 가리지 않고 비교)

		}
		

		System.out.println();
		// char 는 기본적으로 정수값 (아스키 코드값) 이라
		// 일반 산술 비교가 가능.
		// TODO

		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
