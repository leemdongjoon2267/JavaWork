package com.lec.java.j13_04_this;
/*
   클래스 안에서 this : 
	객체 내에서 자기자신(인스턴스)을 가리킴

   메소드 체이닝 (method chaining)
 	자기자신을 리턴하여, 연이어 메소드
 	호출 가능케 하는 메소드 설계
 	보통 setter 와 이와 같은 동작을 수행하는 메소드들에 적용하면 좋다
*/
public class Class04Main {

	public static void main(String[] args) {
		System.out.println("this & 메소드 체이닝");
		
		Number n1 = new Number();
		System.out.println("n1.num = " + n1.getNum());

		Number n2 = new Number(123);
		System.out.println("n2.num = " + n2.getNum());

		n1.setNum(200);
		n2.setNum(111);

		System.out.println("n1.num = " + n1.getNum());
		System.out.println("n2.num = " + n2.getNum());

		n1.add(n2);
		System.out.println("n1.num = " + n1.getNum());
		System.out.println("n2.num = " + n2.getNum());

		n1.setNum(10);
		n2.setNum(20);
		Number n3 = new Number(30);

		n1.add(n2);
		n1.add(n3);
		System.out.println("n1.num = " + n1.getNum()); // 60

		n1.setNum(10);
		n1.add(n2).add(n3); // 메소드 체인(자기 자신을 리턴)
		System.out.println("n1.num = " + n1.getNum()); // 60

		n1.sub(n2).add(new Number(100));
		System.out.println("n1.num = " + n1.getNum()); // 140


		System.out.println("프로그램 종료");
	} // end main()

} // end class Class04Main










