package com.lec.java.j11_03_기본타입배열들;

public class Array03Main {

	public static void main(String[] args) {
		System.out.println("여러가지 자료형의 배열");
		
		System.out.println();
		System.out.println("[1] double형 배열");
		// 타입[] 이름 = new 타입[배열 길이];
		// 타입[] 이름 = new 타입[] {a, b, ...}
		// 타입[] 이름 = {a, b, ...};

		double[] array1 = {1.2, 2.3, 3.4};
		for(int i = 0; i < array1.length; i++){
			System.out.printf("array1[%d] = %f\n", i, array1[i]);
		}
		
		
		System.out.println();
		System.out.println("[2] char형 배열");
		
		char[] array2 = new char[5];
		array2[0] = 'a';
		array2[1] = 'b';
		array2[2] = 'c';
		array2[3] = '가';
		array2[4] = '나';

		
		System.out.println();
		System.out.println("[3] boolean형 배열");

		// TODO
		
		
		System.out.println();
		System.out.println("[4] String형의 배열");

		String[] array4 = new String[3];
		array4[0] = "Java";
		array4[1] = "C++";
		array4[2] = "HTML";

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Array03Main



























