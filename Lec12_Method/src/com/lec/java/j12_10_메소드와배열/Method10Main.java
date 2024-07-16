package com.lec.java.j12_10_메소드와배열;

import java.util.Arrays;
import java.util.Scanner;

/* 메소드와 배열
 * 매개변수가 배열,  리턴타입이 배열
 */
public class Method10Main {

	public static void main(String[] args) {
		System.out.println("메소드와 배열");

		final int NUM_STUDENT = 5;

		Scanner sc = new Scanner(System.in);

		int[] score = new int[NUM_STUDENT];
		System.out.println(Arrays.toString(score));
		inputScore(sc, score);
		System.out.println(Arrays.toString(score));
		// Call By Reference

		// 점수들 중에서 최댓값 출력
		int max = findMax(score);
		System.out.println("최댓값: " + max);

		int[] newArr = doubleUp(score);
		System.out.println(Arrays.toString(newArr));


		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()
	
	// method name: inputScore
	// return: void
	// arguments: 
	//   1) Scanner sc - 입력장치
	//   2) int[] score: 점수를 입력받아서 저장할 배열
	public static void inputScore(Scanner sc, int[] score){
		for (int i = 0; i < score.length; i++) {
			score[i] = sc.nextInt();
		}
	}
	
	// method name: displayScore
	// return: void
	// arguments: int[] score - 출력할 점수가 저장된 배열
	// TODO

	// method name: doubleUp()
	// return: int[]  (생성된 배열)
	// arguments: int[] (입력 배열)
	//   입력된 배열의 원소들을 x2 를 한 새로운 배열 생성하여 리턴
	public static int[] doubleUp(int[] arr){ // 리턴타입과 매개변수가 배열
		int[] result = new int[arr.length]; // 기존 배열의 길이만큼 크기를 정해줌

		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i] * 2;
		}

		return result;
	}
	
	// method name: calcTotal
	// return: int (계산된 총점을 리턴)
	// arguments: int[] score (점수들을 저장한 배열)
	// TODO

	
	// method name: findMax
	// return: int (최대값)
	// arguments: int[] score (점수들 저장된 배열)
	public static int findMax(int[] score){
		int max = score[0];
		for(int x : score){
			max = (x > max) ? x : max;
		}
		return max;
	}
	
	
	// method name: findMin()
	// return: int (최소값)
	// arguments: int[] score
	// TODO


	
} // end class Method09Main












