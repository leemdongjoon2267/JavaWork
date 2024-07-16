package com.lec.java.j19_03_StringBuilder;

/*  StringBuffer, StringBuilder

	 String 클래스는 immutable 클래스이고,
	 StringBuffer, StringBuilder는 mutable 클래스임
	 immutable : 원본이 변경되지 않음


	 StringBuffer:
		Java ver 1.0부터 있던 클래스
		쓰레드에 안전(thread-safe), 속도가 느림
	
	 StringBuilder:
		Java 5부터 생긴 클래스
		쓰레드에 안전하지 않다(thread-unsafe), 속도가 빠름.
	
		그 외에는 StringBuffer와 StringBuilder는 같은 기능(메소드)을 갖고 있음
		

	** 웹 프로그래밍 등에선 문자열을 '붙여 나가며' 완성하는 동작을 많이 함
		실무에서는
			String 을 concat() (혹은 + 연산)하기 보다는
			StringBuffer 를 append() 하는 것을 더 많이 사용함  (성능 UP)
			
		※ 그러나 학습예제에선 예제단순화를 위해 String 을 기본적으로 사용하니 참조 바랍니다
 */
public class String03Main {

	public static void main(String[] args) {
		System.out.println("[1] StringBuffer, StringBuilder");
		// String 클래스는 immutable 클래스이고,
		// StringBuffer, StringBuilder는 mutable 클래스임
		
		System.out.println("[String: immutable]");

		String str1 = "Hello";
		String str2 = str1;

		System.out.println("str1 = " +str1);
		System.out.println("str2 = " +str2);
		System.out.println(str1 == str2); // 동일 참조

		str1 = str1.concat("Java"); // new (새로운 객체를 만듬)

		System.out.println("str1 = " +str1);
		System.out.println("str2 = " +str2);
		System.out.println(str1 == str2);
		
		System.out.println();
		System.out.println("[StringBuffer: mutable]");

		
		StringBuffer buff1 = new StringBuffer("Hello");
		StringBuffer buff2 = buff1;

		System.out.println("buff1 = " + buff1);
		System.out.println("buff2 = " + buff2);
		System.out.println(buff1 == buff2); // 동일 참조

		buff1.append("Java"); // concat 이랑 비슷함
		// mutable 객체의 메소드는 동일한 동작이라도 immutable과 이름이 다르게 설계되어 있다
		// String.concat()  vs  StringBuffer.append()

		System.out.println("buff1 = " + buff1);
		System.out.println("buff2 = " + buff2);
		System.out.println(buff1 == buff2); // concat 이랑 비슷하지만 true 반환
		// str1만 바뀌는게 아니라 str2도 바뀜(내부 내용이 바뀜, 새로운 객체가 생성된게 아님)


		// StringBuffer:
		//  Java ver 1.0부터 있던 클래스
		//  쓰레드에 안전(thread-safe), 속도가 느림
		
		// StringBuilder:
		// Java 5부터 생긴 클래스
		// 쓰레드에 안전하지 않다(thread-unsafe), 속도가 빠름.
		
		// 그 외에는 StringBuffer와 StringBuilder는 같은 기능을 갖고 있음
		
		
		// TODO
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












