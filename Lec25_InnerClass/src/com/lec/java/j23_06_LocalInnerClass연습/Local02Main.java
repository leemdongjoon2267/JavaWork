package com.lec.java.j23_06_LocalInnerClass연습;

public class Local02Main {

	public static void main(String[] args) {
		System.out.println("Local 내부 클래스의 활용");

		Person person = new Person("ABC");
		person.readAge(10);
		System.out.println();
		person.readAge(44);
		System.out.println();

		MyReadable r = person.createInstance(16);
		r.readInfo(); // ★다른 클래스에서도 로컬블래스에서 구현(정의)된 매소드 사용가능

	} // end main()

} // end class Local02Main














