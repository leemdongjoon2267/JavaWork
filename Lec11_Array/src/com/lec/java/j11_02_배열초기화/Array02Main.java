package com.lec.java.j11_02_배열초기화;
/*  배열의 선언과 초기화
 	
 	배열 선언 따로, 초기화 따로
		타입[] 이름 = new 타입[배열의 길이];
		
	배열을 선언과 동시에 초기화 1
		타입[] 이름 = new 타입[] {a, b, c, ...};
		
	배열을 선언과 동시에 초기화 2
		타입[] 이름 = {a, b, c, ...};
		
	배열의 길이를 자동으로 알 수 있는 방법
		배열이름.length 
 */
public class Array02Main {

	public static void main(String[] args) {
		System.out.println("배열의 선언과 초기화");
		
		int[] korean = new int[3];
		korean[0] = 100;
		korean[1] = 90;
		korean[2] = 80;

		System.out.println();
		System.out.println("[2] =====");
		// 배열을 선언과 동시에 초기화 2
		// 타입[] 이름 = new 타입[] {a, b, c, ...};
		// 주의: new를 할 때 배열의 길이를 명시하지 않는다.
		// {}안에 배열의 원소가 몇 개인 지를 보고 배열의 길이가 결정됨

		int[] english = new int[]{30, 20, 30};
		for(int n =0; n < 3; n++){
			System.out.println("영어" + n + ":" + english[n]);
		}

		System.out.println();
		System.out.println("[3] =====");
		// 배열을 선언과 동시에 초기화 3
		// 타입[] 이름 = {a, b, c, ...};
		// {} 안에 있는 원소들의 개수를 보고 배열의 길이가 결정됨

		int[] math = {99, 88 ,77, 66};
		for(int i = 0; i < 4; i++){
			System.out.println("수학" + i + ":" + math[i]);
		}

		System.out.println();
		System.out.println("[4] =====");
		// 배열의 길이를 자동으로 알 수 있는 방법
		// 배열이름.length
		// (예) korean.length, english.length, math.length
		int[] score = {10, 20, 30, 40, 50, 88};

		System.out.println(score.length); // 6

		int total = 0;
		for(int i = 0; i < score.length; i++){
			System.out.println(score[i]);
			total += score[i];
		}
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (double)total / score.length);






		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Array02Main











