package com.lec.java.j13_01_클래스정의;

/**
 *  클래스 정의 및 사용
 *
 *  우리가 만든 클래스를 사용하려면,
 * 	그 클래스의 '인스턴스(실체 instance)'를 생성해야 함.
 *
 * 	구문
 * 		클래스이름 변수이름 = new 생성자();
 * 		생성자(): 클래스의 이름과 동일, 클래스의 멤버변수들을 초기화
 *
 *  new 로 생성하는 instance 들은
 *  	지역변수와는 달리 인스턴스가 생성될 때 (자동으로) 초기화가 된다.
 *  	특별히 초기화를 할 값들이 지정되어 있지 않을 때는
 *  	각 변수 타입의 기본값(디폴트 값)으로 초기화가 됨
 *  		boolean -> false, 숫자타입(int, double, ...) -> 0
 *  		String, 참조 타입(클래스) -> null
 *
 *  지역변수: 메소드 안에서 선언된 변수
 *  	지역변수는 사용하기 전에 반드시 초기화를 해줘야 함.
 */
public class Class01Main {

	public static void main(String[] args) {
		System.out.println("클래스 생성 & 사용");
		
		MyTV tv1 = new MyTV();

		System.out.println(tv1);

		// 일반적으로
		// 멤버변수(필드)는 private 으로 설정.
		// 멤버메소드는 public 으로 설정.
		// private의 경우 외부 클래스에서 직접적으로 사용 불가.
		// public 의 경우 외부 클래스에서 사용 가능

//				System.out.println(tv1.isPowerOn);

		tv1.displayStatus(); // 해당 필드의 메소드 출력

		tv1.powerOnOff();

		tv1.volumeUp();
		tv1.volumeUp();

		tv1.channelUp();
		tv1.powerOnOff();

		System.out.println();
		MyTV tv2 = new MyTV(); // 새로운 TV 인스턴스 생성

		tv2.powerOnOff();
		tv2.channelUp();
		tv2.channelUp();
		tv2.volumeUp();
		tv2.volumeUp();
		tv2.volumeUp();
		tv2.displayStatus();

		System.out.println("tv1: " + tv1);
		System.out.println("tv2: " + tv2);

		System.out.println(tv1 == tv2); // 레퍼런스 변수가 가지고 있는 주소값을 비교 false

		tv1 = tv2;
		tv1.displayStatus(); // tv1에 tv2를 대입했으므로 tv2의 상태가 나옴
		tv1.powerOnOff();
		tv2.displayStatus();

		System.out.println(tv1 == tv2); // true

		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class










