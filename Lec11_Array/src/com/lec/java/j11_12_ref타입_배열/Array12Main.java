package com.lec.java.j11_12_ref타입_배열;

import java.util.Arrays;

public class Array12Main {

	public static void main(String[] args) {
		System.out.println("Reference 타입 주의할 사항");

		int a = 10;
		int b = 20;
		System.out.println("a : " + a + ", b : " + b);
		a = b;
		System.out.println("a : " + a + ", b : " + b);
		a = 30;
		System.out.println("a : " + a + ", b : " + b);

		System.out.println();

		// 배열은?

		int [] arrA = new int[]{10, 10, 10};
		int [] arrB = new int[]{20, 20, 20};
		System.out.println("A:" + Arrays.toString(arrA) + ", B:" + Arrays.toString(arrB));
		arrA = arrB; // 왼쪽꺼는 가비지 콜렉터에 의해 없어짐
		System.out.println("A:" + Arrays.toString(arrA) + ", B:" + Arrays.toString(arrB));
		arrA[0] = 500;
		System.out.println("A:" + Arrays.toString(arrA) + ", B:" + Arrays.toString(arrB));


		System.out.println("\n프로그램 종료");
	} // end main

} // end class
