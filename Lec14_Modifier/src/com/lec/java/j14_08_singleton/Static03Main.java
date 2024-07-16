package com.lec.java.j14_08_singleton;

/*
 * Singleton 디자인
 * 	인스턴스가 최대 1개까지만 생성되어야 하는 디자인 패턴
 */

public class Static03Main {

	public static void main(String[] args) {
		System.out.println("Singleton 디자인 패턴");

//		Test t1 = new Test(); // private 여서 호출 못함?
//		Test t2 = new Test();

		Test t1 = Test.getInstance(); // Test.getInstance 를 해서 인스턴스를 생성
		System.out.println(t1.getNum()); // 100
		t1.setNum(123);
		System.out.println(t1.getNum()); // 123

		System.out.println();
		Test t2 = Test.getInstance();
		// t1에서 인스턴스값이 들어갔으니 null 이 아니므로 인스턴스를 생성안하고 바로 인스턴스 리턴
		t2.setNum(45678);
		System.out.println(t1.getNum()); // 45678
		System.out.println(t2.getNum()); // 45678

		System.out.println(t1); // t2랑 동일 인스턴스
		System.out.println(t2);
		System.out.println(t1 == t2); // 주소 비교

	} // end main()

} // end class Static03Main











