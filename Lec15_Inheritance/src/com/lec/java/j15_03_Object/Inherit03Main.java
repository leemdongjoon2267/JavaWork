package com.lec.java.j15_03_Object;

/* java.lang.Object
 * 	자바의 모든 클래스는 java.lang.Object로부터 상속 받는다.
 *  java.lang.Object 클래스는 모든 클래스의 부모클래스이다.
 *  Object 클래스에 있는 메소드를 다른 클래스에서도 사용 가능
 *
 *  https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html
 */
public class Inherit03Main {

	public static void main(String[] args) {
		System.out.println("상속 연습");
		System.out.println("java.lang.Object");
		
		Person p1 = new Person();
		p1.name = " 홍길동";
		p1.whoAmI();

		System.out.println();
		BusinessPerson p2 = new BusinessPerson();
		p2.whoAmI();
		p2.name = "허균";
		p2.company = "(주)조선";
		p2.showInfo();

		System.out.println(p2); // p2 의 주소값
		System.out.println(p2.toString()); // 위에랑 같음

		System.out.println("p2: " + p2); // toString() 동작

		System.out.println("\n프로그램 종료");
	} // end main()
} // end class









