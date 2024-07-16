package com.lec.java.j14_05_final;

public class Final01Main {

	// final 멤버 변수
	// (주의) final 멤버 변수는 반드시 선언과 동시에 초기화 (혹은 생성자에서 초기화) 해야 한다

	final int NUM1 = 1; // 전역번수는 생성과 동시에 초기화 해줘야함
//	final int NUM2;

	final int NUM3;

	// 위에 하나만 있으면 오류나지만 아래처럼 정의 해줘서 하면 오류 안남
	// public, private, protected 아무거나 받아도 되지만 상속이나 인터페이스 등을 사용할때
	// 상황을 고려해가면서 사용해야함
	public Final01Main(){
		NUM3 = 10;
	}

	public static void main(String[] args) {
		System.out.println("final: 변경할 수 없는 상수");

		int num1 = 1; // 변경 가능
		num1 = 10;

		final int num2 = 1; // 변경 불가능
//		num2 = 10;

		final int num3;
		num3 = 1;
//		num3 = 10; // 변경 불가능

	} // end main()

} // end class Final01Main










