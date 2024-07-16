package com.lec.java.j23_07_AnonymousClass;

/* Anonymous inner class(익명 내부 클래스):
 * 	이름이 없는 local inner class
 * 	이름이 없기 때문에 생성자로 만들 수가 없습니다.
 * 	클래스의 정의와 동시에 인스턴스를 생성합니다.
 * 
 * 익명 내부 클래스:
 * 	인스턴스 생성과 동시에 이름없는 클래스가 정의됨.
 * 
 * 	new 인터페이스() { 익명 클래스 내부 작성 };
 * 	new 부모클래스() { 익명 클래스 내부 작성 };
 * 
 * 익명 내부 클래스 (Anonymous Inner class) 는
 * 인터페이스 뿐 아니라, 일반 클래스, 추상클래스 등도 가능하다.
 *  상속 받은 (이름없는) 클래스의 인스턴스를 생성.
 *  - 멤버 변수/ 메소드 선언
 *  - 메소드 오버라이딩 
*/
public class Anonymous01Main {

	public static void main(String[] args) {
		System.out.println("Anonymous Inner Class(익명 내부 클래스)");
		
		Person p = new Person("이기훈");
		MyReadable r = p.createInstance(20); // 인스턴스
		r.readInfo(); // 주인공은 readInfo() 메소드다. 이 메소드가 정의되어 공급

		System.out.println(r);
		// com.lec.java.j23_07_AnonymousClass.Person$1@568db2f2
		// 여기서 Person$1 부분은 익명객체여서 이렇게 나옴
		//------------------------------------------------
		System.out.println();
		// 인터페이스
		MyReadable r2 = new MyReadable() {

			int a = 10; // 익명클래스에서 필드변수 추가
			@Override
			public void readInfo() {
				System.out.println("readInfo()");
				System.out.println("a = " + a);
			}
		};
		r2.readInfo();

		System.out.println(r2);
		// 메인에서 생성한 익명클래스 toString 으로 출력


		int n = 12;
//		n = 100; // effective final 은 사용가능
		// 바로 익명 객체 생성
		new MyReadable() {
			int a = 200;
			@Override
			public void readInfo() {
				System.out.println(a + 100 + n);
			}
		}.readInfo(); // 익명 객체를 만들고 a + 100을 곧바로 호출
		
		//------------------------------------------------
		System.out.println();
		System.out.println(new MyClass().methodA(30));
		System.out.println(new MyClass(){

			int d = 400;

			// methodA 오버라이딩, 메소드 A 는 여기서 바로 실행
			@Override
			int methodA(int c) {
				return super.methodA(c) + d;
			}
		}.methodA(30));

		System.out.println();

		int k = 300;
		int result = new MyAbstract(){

			// 추상 메서드
			@Override
			int methodB(int a) {
				return a + n + m + k;
			}
		}.methodB(100);
		System.out.println("result = " + result);
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

//익명 내부 클래스 (Anonymous Inner class) 는
//인터페이스 뿐 아니라, 일반 클래스, 추상클래스 등도 가능하다.
//상속 받은 (이름없는) 클래스의 인스턴스를 생성.
//	- 멤버 변수/ 메소드 선언
//	- 메소드 오버라이딩 

abstract class MyAbstract{

	int n = 10;
	int m = 2;

	// 추상 메소드
	abstract int methodB(int a);

} // end class

class MyClass {

	int a = 10;
	int b = 20;
	int methodA(int c){return  a + b + c;}

} // end class












