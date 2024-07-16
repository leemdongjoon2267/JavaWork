package com.lec.java.j08_04_for연습;

public class For04Main {

	public static void main(String[] args) {
		System.out.println("for문 연습");
		
		// 1 부터 n 까지의 합
		int n = 10;
		int sum = 0; // 합을 담는 변수 설정
		for(int i = 0; i < n; i++){
			// i : 0 ~ n-1
			sum += i + 1;
		}
		System.out.printf("1 부터 %d 까지 합 : %d\n", n, sum);

	} // end main ()

} // end class For04Main










