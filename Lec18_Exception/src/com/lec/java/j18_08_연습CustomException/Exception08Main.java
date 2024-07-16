package com.lec.java.j18_08_연습CustomException;

import java.util.Scanner;

public class Exception08Main {

	static Scanner sc = new Scanner(System.in);

	// TODO : AgeInputException 을 throws 하는 메소드 정의
	public static int inputAge() throws AgeInputException{
		System.out.println("나이 입력:");
		int age = sc.nextInt();

		// age 값이 음수이면
		// TODO : AgeInputException 을 throw 하기
		if(age < 0){
			throw new AgeInputException();
		}


		return age;

	} // end inputAge()


	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기 2");


		// TODO
		// 제대로 입력받을때까지 예외 처리 하면서 계속 입력받게 하기

		while(true){
			try{
				int age = inputAge();
				System.out.println("나이: " + age);
				break;
			} catch(AgeInputException ex){
				System.out.println(ex.getMessage());
				System.out.println("다시 입력하세요");
			}
		}



		System.out.println("프로그램 종료...");

	} // end main()

} // end class Exception08Main












