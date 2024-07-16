package com.lec.java.j18_03_try_catch연습;

/*  예외 처리: try ~ catch
 *  연습 01패키지에서 발생하던 예외들을 try~catch로 잡아보자
 *  주의! : try 나 catch 블럭 안에서 선언된 변수는 해당 블럭안에서만 사용되는 지역변수가 된다.
 *        다른 블럭에서도 사용 가능하게 하려면 try 바깥에서 선언해야 한다
 *
 */

public class Exception03Main {

	public static void main(String[] args) {
		System.out.println("예외 처리: try ~ catch");
		
		System.out.println();
		System.out.println("[1] ArithmeticException");
		int num1 = 123;
		int num2 = 0;

		// 주의! : try 블럭 안에서 선언된 변수는 try 블럭안에서만 사용되는 지역변수가 된다.
		//     catch 블럭등 다른 블럭에서도 사용 가능하게 하려면 try 바깥에서 선언해야 한다

		try{
			System.out.println("num1 / num2 = " + (num1 / num2));
		}catch(ArithmeticException ex){
			System.out.println(num1 + "은 " + num2 + "로 나눌 수 없습니다");
//			System.out.println(ex.getMessage());
		}

		
		
		System.out.println();
		System.out.println("[2] ArrayIndexOutOfBoundsException");

		try{
			int[] numbers = new int[10];
			numbers[100] = 111;
		}catch (ArrayIndexOutOfBoundsException ex){
			System.out.println("배열 index 값이 잘못됬습니다");
			System.out.println(ex.getMessage());
		}

		
		System.out.println();
		System.out.println("[4] NullPointerException");

		try{
			String str = null;
			System.out.println("스트링 길이: " + str.length());
		}catch (NullPointerException ex){
			System.out.println("null 값이 들어갈 수 없습니다");
			System.out.println(ex.getMessage());
		}

		
		System.out.println();
		System.out.println("[5] ClassCastException");

		try{
			Object obj = new int[10];
			String str2 = (String)obj;
		}catch (ClassCastException ex){
			System.out.println("호환되지 않는 클래스 변형입니다");
			System.out.println(ex.getMessage());
		}

		
		System.out.println("\n프로그램 정상종료");
	} // end main

} // end class Exception03Main












