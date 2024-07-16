package com.lec.java.j24_01_Lambda;

/* 람다 표현식: lambda-expression
 * 	Java8 부터 도입:
 * 		(매개변수 리스트) -> 리턴값
 * 		(매개변수 리스트) -> {...}  수행코드
 *
 * 	람다 표현식은 추상메소드가 '하나뿐'인 인터페이스 구현. (이를 함수형 인터페이스 functional interface) 라 한다
 *  @FunctionalInterface 를 사용하여 명시적으로 함수형 인터페이스임을 지정할수 있다
 *
 * 	- 익명클래스의 더 간략화한 표현식
 * 	- 함수 한개(메소드 한개)를 표현하기 위한 식
 */

public class Lambda01Main {

	public static void main(String[] args) {
		System.out.println("인터페이스, 익명 클래스, 람다 표현식");

		
		System.out.println();
		System.out.println("[1] 인터페이스를 구현하는 클래스");
		Addable myAdder = new AdderImpl();
		double result = myAdder.add(1.11, 2.22);
		System.out.println("result = " + result);
				
		System.out.println();
		System.out.println("[2] 익명 클래스 사용");
		Addable myAdder2 = new Addable() {
			@Override
			public double add(double x, double y) {
				return x + y;
			}
		};
		result = myAdder2.add(1.11, 2.22);
		System.out.println("result = " + result);
		
		System.out.println();
		System.out.println("[3] 람다 표현식(lambda expression) 사용");
		Addable myAdder3 = (a, b)-> a + b; // Addable 의 익명객체 만듬
		// 괄호안에 매개변수 명시(타입 필요없음) -> 뒤에 해당 리턴 타입 입력
		// 람다 표현식 결과물 : 익명객체
		result = myAdder3.add(1.11, 2.22);
		System.out.println("result = " + result);

		//---------------------------------------
		System.out.println();
		// Addable 객체의 배열
		Addable[] arr = {
			(a, b) -> a + b,
				(예현, 세진) -> 예현 * 세진,
				(베리, 베베) -> 베리 * 베베,
				(x, y) -> x / y,
		};

		for(var a : arr){
			System.out.println(a.add(10.0, 20.0));
		}

		// 매개변수와 리턴타입 : 추상 메소드의 형태가 중요
		showResult(100.0, 50.0, (r, t) -> r + t);
		showResult(4.0, 3.0, (k, u) -> Math.pow(k, u)); // k 의 u 승

		System.out.println("\n프로그램 종료");
	} // end main()

	public static void showResult(double x, double y, Addable func){
		System.out.println(func.add(x, y));
	}
	
} // end class


@FunctionalInterface // 인터페이스에 실수로 추상메소드를 두개 만들시 바로 에러 뜸
// 함수형 인터페이스 정의
interface Addable{
	// 추상 메소드가 딱 하나
	double add(double x, double y);
//	double sub(double x, double y); // lambda 표현식으로 구현할 인터페이스는 추상메소드가 딱 한개 있어야 함
}

//인터페이스를 구현하는 클래스를 정의
class AdderImpl implements Addable{

	@Override
	public double add(double x, double y) {
		return x + y;
	}
}












