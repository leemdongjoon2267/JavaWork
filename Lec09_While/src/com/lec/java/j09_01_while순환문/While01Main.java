package com.lec.java.j09_01_while순환문;

/*
 * while 순환문
 * 
 * [구문]
 * while(조건식) {
 *    ...
 * }
 * 
 * 조건식이 '참' (true) 인 동안 while 블럭 반복
 * 
 */
public class While01Main {

	public static void main(String[] args) {
		System.out.println("while 반복문");
		
		int count = 1;
		while(count <= 3){
			System.out.println(count);
			count++; // 출력하고 count값을 1씩증가(이게 없으면 조건식이 계속 true이므로 무한루프에 빠짐)
		}

		System.out.println();
		// 10, 9, 8, .... 1 까지 출력

		int num = 10;
		while(num > 0){
			System.out.println(num);
			num--;
		}

		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class While01Main









