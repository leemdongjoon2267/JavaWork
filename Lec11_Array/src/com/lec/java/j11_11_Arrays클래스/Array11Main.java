package com.lec.java.j11_11_Arrays클래스;

import java.util.Arrays;

/* java.util.Arrays 클래스
     배열을 다루는 유용한 메소드들 제공
		Arrays.toString() : 문자열 형태로 리턴
		Arrays.copyOf(원본배열, 복사할 length)
		Arrays.copyOfRange(원본배열, from, to))
		Arrays.fill()  : 배열에 특정 값으로 채우기
		Arrys.sort(원본배열) :  오름차순 변경
		Arrays.asList() : array -> List 로
 */
public class Array11Main {

	public static void main(String[] args) {
		System.out.println("java.util.Arrays 클래스");

		int[] arr = {10, 20, 30, 40, 50};

		System.out.println(arr);
		System.out.println("arr:" + Arrays.toString(arr));  // 문자열 형태로 리턴

		int[]arr2 = arr;
		System.out.println("arr2:" + Arrays.toString(arr2));

		arr2[0] = 1000;
		System.out.println("arr2:" + Arrays.toString(arr2));
		System.out.println("arr:" + Arrays.toString(arr));

		// 기존 배열의 사본 생성
		arr2 = Arrays.copyOf(arr, 3);
		// 원본 배열에서 3개의 요소만 복사해서 새로운 배열을 만듬
		System.out.println("arr2:" + Arrays.toString(arr2));
		arr2[0] = 456;
		System.out.println("arr2:" + Arrays.toString(arr2));
		System.out.println("arr:" + Arrays.toString(arr));


		System.out.println("\n프로그램 종료");
	} // end main

} // end class
