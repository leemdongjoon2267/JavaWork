package com.lec.java.j23_01_MemberInnerClass;

/*
 Inner Class(내부 클래스)
 1. Member inner class(멤버 내부 클래스): 다른 클래스 내부에서 선언된 클래스
 2. Static inner class(static 내부 클래스): 다른 클래스의 내부에서 static으로 선언된 클래스
 3. Local class(지역 클래스)
   1) Local inner class(지역 내부 클래스): 메소드 내부에서 선언된 클래스
   2) Anonymous inner class(익명 내부 클래스): 이름이 없는 local class
*/

public class Inner01Main {

	public static void main(String[] args) {
		System.out.println("Member Inner Class(멤버 내부 클래스)");

		// 외부 클래스의 인스턴스 생성 (외부 클래스의 인스턴스를 먼저 생성 안하면 안됨)
		TestOuter out = new TestOuter(100);
		// 멤버 내부 클래스의 인스턴스 생성
		// 멤버 내부 클래스의 이름: [외부클래스 이름].[멤버 내부클래스 이름]
		// [외부클래스 이름].[내부클래스 이름] 참조변수 =
		//      [외부클래스 인스턴스].new 내부클래스 생성자();

		TestOuter.TestInner in = out.new TestInner(111);
		// 외부 안에 있는 내부를 생성?
		in.printOuterValue(); // 100 (내부)
		in.printInnerValue(); // 111 (내부)

		// 하나의 외부 클래스 인스턴스를 이용해서
		// 멤버 내부 클래스의 인스턴스는 여러개를 생성할 수 있다.

		System.out.println();
		TestOuter.TestInner in2 = out.new TestInner(123);
		// 같은 외부 클래스에서 다른 내부 클래스의 인스턴슬를 생성함
		in2.printOuterValue(); // 100, 위에서 100으로 만들어서 그대로 나옴
		in2.printInnerValue(); // 123, outer 는 고정이지만 inner 은 고정아님

		TestOuter.TestInner in3 = out.createInner(303);
		in3.printOuterValue(); // 100, out 을 했기 때문에 outerValue 는 바뀌지 않음
		in3.printInnerValue(); // 303




	} // end main()

} // end class Inner01Main

















