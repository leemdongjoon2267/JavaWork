package com.J03.Generic메소드;

/* Generic메소드
 *
 *   제네릭 메소드는 메소드의 선언부에 적은 타입 파라미터로
 *    '리턴 타입' 이나 '파라미터 타입'이 정해지는 메소드
 *
 *   <타입파라미터..> 리턴타입 메소드명(매개변수) {...}
 *
 *   Ex)
 *    <T, R> R MethodName (T t) // R 타입을 리턴하고 T 타입을 매개변수로 하는 메서드
 *
 */

public class Generic03Main {

	public static void main(String[] args) {
		System.out.println("Generic 메소드");
		
		test1(123); // test1 은 T 타입의 파라미터를 받음, wrapper 객체가 나옴(Integer)
		test1(123.); // Double
		test1(123.f); // Float
		test1("123"); // String

		System.out.println();
		System.out.println(test2(123).getClass());
		System.out.println(test2(123.).getClass());
		System.out.println(test2(123.f).getClass());
		System.out.println(test2("123").getClass());

		Box<String> sBox = boxing("Apple"); // Box<String> 리턴
		System.out.println(sBox.data);

		Box<Integer> nBox = boxing(34); // Box<Integer> 리턴
		System.out.println(nBox.data);

		var fBox = boxing(3.14f);
		System.out.println(fBox.data); // Box<Float> 리턴

		System.out.println("\n프로그램 종료");

	} // end main()

	// static 메소드는 generic 사용 가능, 역으로는 불가능
	public static <T>void test1(T param){
		System.out.println(param + " : " + param.getClass());
		// getClass() 는 오브젝트에 있는 메서드
	}

	// 리턴 타입이 T 매개변수는 T 타입
	public static <T> T test2(T param){
		return param;
	}

	// 리턴 타입이 Box<T> 타입 매개변수는 T 타입
	public static <T> Box<T> boxing(T t){
		Box<T> box = new Box<>();
		box.setData(t);
		return box;
	}

} // end class

class Box<K>{
	K data;

	public void setData(K data) {
		this.data = data;
	}
}


















