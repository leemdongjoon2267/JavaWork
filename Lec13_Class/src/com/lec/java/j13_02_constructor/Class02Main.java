package com.lec.java.j13_02_constructor;



public class Class02Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습");		
		
		Circle c1 = new Circle(); // 인스턴스가 생성되고 struc 호출
		Circle c2 = new Circle(3);

		System.out.println("c1의 둘레" + c1.calcPerimeter());
		System.out.println("c2의 둘레" + c2.calcPerimeter());
		System.out.println("c1의 넓이" + c1.calcArea());
		System.out.println("c2의 넓이" + c2.calcArea());

		System.out.println();

		Rectangle r1 = new Rectangle(3,2);

		System.out.println("r1의 둘레" + r1.calcPerimeter());
		System.out.println("r1의 넓이" + r1.calcArea());
		System.out.println("프로그램 종료");
	} // end main()

} // end class Class02Main










