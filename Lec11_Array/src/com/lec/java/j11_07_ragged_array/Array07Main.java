package com.lec.java.j11_07_ragged_array;

/**
 *  ragged array (혹은 jagged array)
 *  column(열)의 개수가 일정하지 않은 배열
 *
 *  가변 배열 선언 방법: 행의 개수만 지정을 하고, 열의 개수는 비워둠
 *  열(column)이 몇 개가 될 지 모르기 때문에 메모리 할당이 되지 않습니다.
 */
public class Array07Main {

	public static void main(String[] args) {
		System.out.println("Ragged Array(가변 배열)");

		int[][] array = {
				{1, 2},
				{3, 4, 10, 20},
				{5, 6, 100}
		};

		System.out.println(array[0][1]);
//		System.out.println(array[0][2]); // 오류
		System.out.println(array[1][2]);
		System.out.println(array[2][2]);


		for(int x = 0; x < array.length; x++){
			for(int y = 0; y < array[x].length; y++){
				System.out.print(array[x][y] + "\t");
			}
			System.out.println();
		}
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Array09Main

