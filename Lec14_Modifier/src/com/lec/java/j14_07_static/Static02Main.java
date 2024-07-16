package com.lec.java.j14_07_static;

//클래스 변수 / 메소드 특징 (static)
//1. 메모리의 '메소드 영역'에 클래스가 로드 될때(프로그램 시작될때) '한번만' 생긴다
//2. 인스턴스가 생성되지 않아도 사용할 수 있다.
//		- 클래스이름.static변수,  클래스이름.static메소드()  <-- 요렇게 사용한다
//3. 모든 인스턴스는 하나의 static 변수/메소드를 '공유'한다.


public class Static02Main {

	public static void main(String[] args) {
		System.out.println("인스턴스 변수/메소드");

		// static 변수도 기본값으로 초기화 되어있다
//		Test.show(); // static 이 안붙어서 호출 불가능
		Test.show2();
		System.out.println(Test.sNum);

//		Test.show();
//		System.out.println(Test.num);

		// 인스턴스 변수/메소드는
		// 인스턴스 생성(new)후 사용 가능

		Test t = new Test();
		t.num = 100;
		t.show(); // num : 100, sNum : 0

		Test t2 = new Test();
		t2.show(); // num : 0, sNum : 0

		Test.sNum = 987;
		t.show(); // num : 100, sNum : 987
		t2.show(); // num : 0, sNum : 987
		// 하나의 인스턴스를 가지므로 sNum 값이 동일함

		t2.sNum = 340;
		t.show(); // num : 100, sNum : 340

		System.out.println(Math.PI);

		Test.sNum = 100;
		t.sNum = 500;
		t2.sNum = 700;
		System.out.println(Test.sNum); //700
		System.out.println(t.sNum); // 700
		System.out.println(t2.sNum); // 700

	} // end main()

} // end class Static02Main







