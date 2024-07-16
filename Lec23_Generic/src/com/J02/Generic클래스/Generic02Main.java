package com.J02.Generic클래스;

/* 제네릭 클래스의 타입
 * 	제네릭 클래스에서 사용되는 타입은
 * 	기본 자료형(primitive type)은 사용될 수 없고,
 * 		Object 타입의 자료형들만 올 수 있음.
 * 		(예) int는 사용할 수 없고, Integer를 사용해야 함
 * 		(예) double은 사용할 수 없고, Double을 사용해야 함
 *
 *   static 필드에는 generic 사용 불가.
 *
 *  관례적으로 자주 사용하는 타입파라미터 명
 * 	<T>	Type
 * 	<E>	Element
 *  <K>	Key
 *  <N>	Number
 *  <V>	Value
 *  <R>	Result
 */
public class Generic02Main {

	public static void main(String[] args) {
		System.out.println("Generic 클래스 2");

//		Test<int, String> t1; // 불가
		Test<Integer, String> t1 = new Test<>(123, "Hello, Java");
		t1.display();

		Test t5 = new Test(3.14, "AAA"); // Test<Double, String>

		Test<Integer, Double> t2 = new Test<>(111, 3.14);


		System.out.println("\n프로그램 종료");
	} // end main

} // end class Collection02Main

class Test<T, U>{
	T item1;
	U item2;
//	static T item3; // 에러, static 은 인스턴스와 상관없음

	public Test(T item1, U item2){
		this.item1 = item1;
		this.item2 = item2;
	}


	public void display(){
		System.out.println("item1: " + item1);
		System.out.println("item2: " + item2);
	}

}