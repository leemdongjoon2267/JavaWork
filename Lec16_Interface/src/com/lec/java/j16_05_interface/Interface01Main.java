package com.lec.java.j16_05_interface;

/*
 인터페이스(interface):
 1. 모든 메소드가 public abstract으로 선언되고,
 2. 모든 멤버 변수가 public static final로 선언된
 특별한 종류의 추상 클래스

 인터페이스는 interface라고 선언
 인터페이스를 구현(상속)하는 클래스에서는 implements 키워드를 사용
 인터페이스를 구현(상속)할 때는 개수 제한이 없다. (다중상속)
 메소드 선언에서 public abstract는 생략 가능
 멤버 변수 선언에서 public static final은 생략 가능
*/

public class Interface01Main {

	public static void main(String[] args) {
		System.out.println("인터페이스(interface)");
		
		TestImpl test1 = new TestImpl();
		test1.testAAA();
		test1.testBBB();

		TestImpl2 test2 = new TestImpl2();
		test2.testAAA();
		test2.testBBB();
		test2.testCCC();

//		System.out.println(test2.MIN); // 양쪽 부모에 있어서 겹침
		System.out.println(TestInterface.MIN); // 0
		System.out.println(TestInterface2.MIN); // 1


		TestInterface t1 = new TestImpl2(); // 다중상속으로 인한 다형성
		TestInterface t2 = new TestImpl2();
		t1.testAAA();
		t1.testBBB();
//		t1.testCCC(); // x
		((TestImpl2)t1).testCCC(); // 다운캐스팅으로 가능


		System.out.println("\n 프로그램 종료");
	} // end main()

} // end class


interface TestInterface{
	public static final int MIN = 0;
	int MAX = 100; // public static final 생략 해도 됨
	public static final String JAVA_STRING = "Java";
	String CSHARP_STRING = "C#";

	public abstract void testAAA(); // 추상 메소드
	void testBBB(); // public abstract 생략됨
}

interface TestInterface2{
	public static final int MIN = 1;
	public abstract void testAAA();
	public abstract void testCCC();
}

// 인터페이스는 인스턴스를 생성할 수 없고,
// 다른 클래스에서 구현(implements)해야 함.
class TestImpl implements TestInterface{

	@Override
	public void testAAA() {
		System.out.println("testAAA");
	}

	@Override
	public void testBBB() {
		System.out.println("testBBB");
	}
}

// 인터페이스는 다중상속 가능
class TestImpl2 implements TestInterface, TestInterface2{

	// testAAA() 는 두개의 인터페이스 양쪽에 있었지만
	// 한번만 implement 하면 된다

	@Override
	public void testAAA() {

	}

	@Override
	public void testCCC() {

	}

	@Override
	public void testBBB() {

	}
}

//-------------------------------
/**
 * class 가 class 를 상속받을때 -> extends
 * class 가 interface 를 상속(구현)할때 -> implements
 * interface 가 interface 를 상속할때 -> extends
 */

abstract class A{}


// extends 와 implements 가 동시에 있을때 extends 우선
class B extends A implements TestInterface{

	@Override
	public void testAAA() {

	}

	@Override
	public void testBBB() {

	}
}

interface C extends TestInterface{}




































