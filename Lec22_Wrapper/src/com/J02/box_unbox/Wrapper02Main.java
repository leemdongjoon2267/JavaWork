package com.J02.box_unbox;

/* Java 5부터 wrapper 클래스의 auto-boxing/unboxing 기능 제공
 * 	boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
 * 	unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
 * 
 * Number 를 상속받음
 *    └─ Boolean, Character, Byte, Short, Integer, Long, Float, Double
 *    intValue(), floatValue() 등은 Number의 메소드다.
 */
public class Wrapper02Main {

	public static void main(String[] args) {
		System.out.println("auto-boxing, auto-unboxing");

		Integer num1 = 10; // Integer.valueOf(10); auto-boxing
		Integer num2 = 20;
		Integer num3 = num1 + num2; // num1.intValue(); auto-unboxing
		Integer num30 = Integer.valueOf(num1.intValue()+num2.intValue());
		// num1 : 10, num2 : 20 를 각각 auto unboxing 후 다시 연산하고 boxing 을 함
		System.out.println(num1.intValue()); // num1 안의 int 값 꺼내기

		System.out.println("num3 = " + num3);
		
		System.out.println();
		System.out.println("boxing/unboxing");
		// boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
		// unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
		
		Integer num4  = Integer.valueOf(100); // boxing
		int n4 = num4.intValue(); // unboxing
		System.out.println("n4 = " + n4);
		
		
		System.out.println();
		System.out.println("auto-boxing/auto-unboxing");

		Integer num5 = 200; // auto-boxing
		System.out.println(num5 * 10); // auto-unboxing
		
		System.out.println();
		System.out.println("wrapper 클래스들");
		
		Long num100 = Long.valueOf(10000000000L); // boxing
		long n100 = num100.longValue(); // unboxing

		Double num200 = 3.141592; // auto-boxing
		double n200 = num200 * 2; // auto-unboxing

		//------------------------------------------------
		// 주의!
		//     Wrapper 클래스는 == 와 같은 비교연산시 한쪽이 primitive type 이면 auto-unboxing 하여 비교 하나
		//           비교연산자의 양쪽이 wrapper 인 경우는 주소값으로 비교한다.
		//     ``      num1 와 num2 는 각각 달리 생성된 객체이므로 다른 주소값을 가진다. wrapper 끼리의 비교를 해야 한다면 equals() 를 사용해야 한다


		System.out.println(num1 == 10); // auto-unboxing 발생(int 값 비교), ture
		// 한쪽이 primitive 타입은 오토 언박싱
		System.out.println(num1 == num2); // false (주소비교) auto-unboxing 발생안함
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class















