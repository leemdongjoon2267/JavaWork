package com.lec.java.j14_06_static;

// 클래스에 선언된 멤버 변수/멤버 메소드는
// static 여부에 따라 아래와 같이 불려진다

// 인스턴스 변수: 
//   static 이 안붙은 변수
//   인스턴스를 생성한 다음에(new 생성자(); 호출된 다음에)
//   사용할 수 있는 변수
// 인스턴스 메소드:
//   static 이 안 붙은 메소드
//   인스턴스를 생성한 다음에(new 생성자(); 호출된 다음에)
//   사용할 수 있는 메소드

// 클래스 변수(static 변수):
//   클래스의 멤버 변수들 중에서,
//   인스턴스를 생성하지 않아도 사용할 수 있는 변수
// 클래스 메소드(static 메소드):
//   인스턴스를 생성하지 않아도 사용할 수 있는 메소드


public class Static01Main {

	public static void test1(){ // 클래스 메소드
		System.out.println("Hello Java!");
	}

	public void test2(){ // 인스턴스 메소드(non-static)
		System.out.println("안녕하세요");
		test1(); // Hello Java!
		// non-static 에서 static 가능
		System.out.println(num2);
	}

	int num1; // 인스턴스 변수(non-static)
	static int num2; // 클래스 변수
	
	public static void main(String[] args) {
		System.out.println("인스턴스 변수/메소드 vs 클래스 변수/메소드");


		// static 은 non-static 을  사용할수 없다 ★★
		test1();
//		test2(); // static 은 static 이 붙은거만 사용 가능하거나 호출 가능
		// 하지만 non-static 에서 static 호출 가능 할듯?

		System.out.println(num2); // static 이 붙어서 가능
//		System.out.println(num1);

		// 인스턴스 생성뒤에는 인스턴스 변수/메소드 사용가능
		Static01Main tc = new Static01Main();
		tc.test2(); // tc를 받았으니 static 없이 사용 가능
		System.out.println(tc.num1);

	} // end main()

} // end class Static01Main











