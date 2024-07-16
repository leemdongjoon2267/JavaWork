package com.lec.java.j10_03_nested_loop;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 2단 ~ 9단

		// 2 x 1 = 2
		// ..
		// 2 x 9 = 18
		// 3 x 1 = 3
		// ..
		// 3 x 9 = 27
		// ...
		// 9 x 1 = 9
		// ..
		// 9 x 9 = 81

		// 구구단 출력 : 중첩 for 사용
		for(int dan = 2; dan <= 9; dan++){ // 2단 ~ 9단

			System.out.println("구구단 " + dan + "단");
			for(int mul =1; mul <= 9; mul++){ // x1 ~ x9
				System.out.println(dan + " x " + mul + " = " + (dan * mul));
			}
			System.out.println();
		}
		
		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용

		int i = 2;

		while(i <= 9){
			System.out.println("구구단 " + i + "단");

			int j = 1;
			while(j <= 9){

				System.out.println(i + " x " + j + " = " + (i * j));
				j++;
			}
			System.out.println();
			i++; // 한 단을 출력후 i 값을 증가시켜 다음 단을 출력하게 해줌


		}
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















