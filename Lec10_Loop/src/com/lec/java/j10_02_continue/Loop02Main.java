package com.lec.java.j10_02_continue;

/* continue;
 * 순환문(for, while, do~while) 안에서 continue   를 만나면
 * continue를 감싸는 가장 가까운 순환문 으로 돌아감
 * 
 * 순환문은 종료하지 않고 . 특정 조건만 스킵!
 */

public class Loop02Main {

	public static void main(String[] args) {
		System.out.println("continue;");
		
		int num = 1;
		while(num <= 10){
			num++;

			if(num %2 == 0){
//				System.out.println(num); // continue 를 안쓰고 여기에 출력문만 작성하면 짝수만 찍힘
				continue; // 짝수만 스킵
			}
			System.out.println(num);
		}
		
		
		System.out.println();
		// for문과 continue를 사용해서
		// 1 ~ 10 숫자 중 짝수만 출력
		
		// TODO
		
		System.out.println();
		// 2단은 x 2 부터 출력
		// 3단은 x 3 부터 출력
		
		// TODO



		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















