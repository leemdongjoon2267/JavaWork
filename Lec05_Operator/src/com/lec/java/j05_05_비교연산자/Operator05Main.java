package com.lec.java.j05_05_비교연산자;

/*
	관계(비교) 연산자   Equality and Relational Operators
	
	 비교 연산의 결과를 참(true) 또는 거짓(false)으로 리턴하는 연산자
	 A < B: A는 B보다 작다
	 A > B: A는 B보다 크다
	 A >= B: A는 B보다 크거나 같다
	 A <= B: A는 B보다 작거나 같다
	 A == B: A와 B가 같다.
	 A != B: A와 B는 다르다.	
 */
public class Operator05Main {

	public static void main(String[] args) {
		System.out.println("연산자 5 - 관계(비교) 연산자   Equality and Relational Operators");
		System.out.println("<, >, <=, >=, ==, !=");

		System.out.println(10 < 20);
		System.out.println(10 > 20);
		System.out.println(10 == 20);
		System.out.println(10 != 20);

		// 실수 연산 결과의 비교연산은 주의!
		System.out.println(0.1 + 0.2 == 0.3); // false

		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class






