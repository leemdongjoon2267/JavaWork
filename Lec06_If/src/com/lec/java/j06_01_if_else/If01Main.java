package com.lec.java.j06_01_if_else;

/* if, if ~ else 조건문
 * 
 * 구문1:
 * 	if (조건식) {
 *  	조건식이 true 일때 실행되는 문장(들) 
 *  	...
 * 	}
 * 
 * 구문2:
 *  if (조건식) {
 *		조건식이 true 일때 실행되는 문장(들)
 *		...
 *  } else {
 *		조건식이 false 일때 실행되는 문장(들)
 *		...
 *  }
 */
public class If01Main {

	public static void main(String[] args) {
		System.out.println("if 조건문");

		int num = -10;

		if(num > 0){
			System.out.println("양수입니다");
		}else{
			System.out.println("음수 혹은 0 입니다");
		}

		num = 123;
		if(num % 2 == 0){
			System.out.println(num + "은 짝수 입니다");
		}else{
			System.out.println(num + "은 홀수 입니다");
		}

		// 유효한 점수는 0 <= score <=100
		int score = 400;
		if(score >=0 && score <= 100){
			System.out.println(score + "는 유효한 점수");
		}else{
			System.out.println(score + "는 잘못입력한 점수입니다");
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
