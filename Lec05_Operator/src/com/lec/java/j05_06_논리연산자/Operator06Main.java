package com.lec.java.j05_06_논리연산자;

/* 논리 연산자: &&, ||, !, ^
 *	A && B: (AND 연산) A와 B가 모두 참일 때만 결과가 true, 나머지는 결과가 false
 *	A || B: (OR 연산) A나 B 둘 중 하나가 참이면 결과가 true, 둘 다 거짓이면 결과가 false
 *	!A	: (NOT 연산) A가 참이면 결과가 false, 거짓이면 결과가 true
 *	A ^ B : (XOR 연산)A, B 둘의 논리값이 같으면 false, 다르면 true
 * 			eXclusive OR (배타적 논리합)
 * 
 *  피연산자는 boolean 값
 *  논리연산자의 결과값도 boolean값
 */
public class Operator06Main {

	public static void main(String[] args) {
		System.out.println("연산자 6 - 논리 연산자: &&, ||, !, ^");

		int num1 =10;
		System.out.println(num1 > 0 && num1 < 100); // true
		System.out.println(num1 > 0 && num1 > 100); // false
		System.out.println(num1 > 0 || num1 > 100); // true
		System.out.println(num1 < 0 || num1 > 100); // false

		System.out.println(num1 > 0); // true
		System.out.println(!(num1 > 0)); // false

		System.out.println(num1 < 0 ^ num1 > 100); // false
		System.out.println(num1 > 0 ^ num1 > 100); // true

		System.out.println("\n 프로그램 종료");
	} // end main ()

} // end class











