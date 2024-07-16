package com.lec.java.j10_01_break;

/* break;
 * 순환문(for, while, do~while) 안에서 break를 만나면
 * break를 감싸는 가장 가까운 순환문 종료
 */
public class Loop01Main {

	public static void main(String[] args) {
		System.out.println("Break");
		
		int num = 1;
		while(num <= 10){
			System.out.println(num);

			if(num == 3){
				break; // num 값이 3이면 종료
			}
			num++;
		}
		System.out.println("while 끝난후 num = " + num); // 3
		
		
		
		System.out.println();
		// 1 ~ 100 사이에서 2와 7의 최소공배수를 출력
		// 최소공배수: 공배수 중에서 가장 작은 수

		// TODO
		

		System.out.println();
		System.out.println("무한 루프와 break;");

		num = 1;
		while(true){
			// true는 항상 참이지만 조건문이 없을때 아래 출력문이 실행되지않음(영원히 갈 수 없는 문장)
//			 num++; // 2 ~ 5까지 나옴
			System.out.println(num);
//			 num++; // 4까지 나옴(if 문에서 num 값이 5가 되면 중지를 시키니까 4까지나옴)
			if(num ==5 ){
				break;
			}
			num++; // 5까지 나옴
		}
		
		
		
		System.out.println();
		// 2단은 x 2 까지 출력
		// 3단은 x 3 까지 출력
		
		// TODO

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















