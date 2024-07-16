package com.lec.java.j11_05_다차원배열;

/* 2차원 배열 (2-dimensional array)
 * 	직전의 예제와 같이 같이 배열 첨자를 하나만 쓰는 배열을 
 *  1차원 배열 (one-dimensional array) 이라고 함
 *   배열 첨자를 2개사용하면 2차원 배열
 *   배열 첨자를 3개사용하면 3차원 배열
 *   ...
 *  
 *   배열원소가 '1차원 배열' 들로 이루어진 배열을 2차원 배열 이라 한다  (배열첨자 2개 사용)
 *   배열원소가 '2차원 배열' 들로 이루어진 배열을 3차원 배열 이라 한다  (배열첨자 3개 사용)
*/
public class Array05Main {

	public static void main(String[] args) {
		System.out.println("2차원 배열");
		
		// 1차원 배열
		int[] arr1 = {1, 2};
		// arr1 의 타입? => int[] 타입
		// arr1[0] 의 타입? => int 타입

		// 1차원 배열 x 3개 담고 있는 2차원 배열
		{
			int[][] array = new int[3][]; // 1차원 베열 x3개를 가진 2차원 배열 객체 생성
			array[0] = new int[]{1, 2};
			array[1] = new int[]{3, 4};
			array[2] = new int[]{5, 6};

			System.out.println(array[0][0]); // 0번째의 0번째 출력
			System.out.println(array[0][1]);
			System.out.println(array[1][0]);
			System.out.println(array[1][1]);
			System.out.println(array[2][0]);
			System.out.println(array[2][1]);
		}

		System.out.println();
		// 1차원 배열을 원소로 하는게 2차원 배열
		int[][] array = {
				{1, 2},
				{3, 4},
				{5, 6}
		};

		System.out.println(array[0][0]);
		System.out.println(array[0][1]);
		System.out.println(array[1][0]);
		System.out.println(array[1][1]);
		System.out.println(array[2][0]);
		System.out.println(array[2][1]);

		System.out.println();
		System.out.println(array.length); // int[] 1차원 배열의 개수 : 3
		System.out.println(array[0].length); // 첫번째 배열의 원소의 개수 : 2

		// 중요!
		// array 의 타입은? --> int[][]
		// array[0] 의 타입은?  --> int[]
		// array[0][0] 의 타입은? --> int

		System.out.println();
		for(int x = 0; x < array.length; x++){ // 첫번째 index 순환
			for(int y = 0; y < array[x].length ; y++){ // 두번째 index 순환
				// 배열 x의 길이 만큼
				System.out.print(array[x][y] + "\t");
			}
			System.out.println();
		}

		int[] arr = {10, 20, 30};
		System.out.println(arr); // [I@58372a00 (힙이란 메모리 영역의 주솟값 4byte)

		System.out.println(array); // [[I@4dd8dc3 ([한개 : 1차원, 2개 : 2차원)
		System.out.println(array[0]); // [I@6d03e736

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Array05Main









