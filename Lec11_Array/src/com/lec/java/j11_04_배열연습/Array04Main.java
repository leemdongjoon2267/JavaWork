package com.lec.java.j11_04_배열연습;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");

		int[] scores = {13, 45, 27, 52, 8};

		// 최댓값
		int max = scores[0];
		// n-1번 순환
		for (int i = 1; i < scores.length; i++) {
			if(scores[i] > max)
				max = scores[i];
		}
		System.out.println("최댓값 = " + max);

		// 최솟값
		int min = scores[0];
		// n-1번 순환
		for (int i = 1; i < scores.length; i++) {
			if(scores[i] < min)
				min = scores[i];
		}
		System.out.println("최솟값 = " + min);



		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Array04Main








