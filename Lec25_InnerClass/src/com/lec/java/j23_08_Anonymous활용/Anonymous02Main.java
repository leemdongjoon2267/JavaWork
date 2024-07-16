package com.lec.java.j23_08_Anonymous활용;

public class Anonymous02Main {

	public static void main(String[] args) {
		System.out.println("익명 내부 클래스 활용");

		System.out.println("1. 익명 클래스를 사용하지 않는 경우");
		Calculable tc1 = new TestMyMath();
		double result = tc1.operate(1.0,2.0);
		System.out.println("result = " + result);

		System.out.println();
		System.out.println("2. 익명 클래스 사용");
		Calculable tc2 = new Calculable() {
			@Override
			public double operate(double x, double y) {
				return x + y;
			}
		};
		result = tc2.operate(1.0,2.0);
		System.out.println("result = " + result);
		System.out.println();

		// 도전]
		// operate() 가 x - y 를
		// operate() 가 x * y 를
		// operate() 가 x / y 를
		// 리턴하는 익명클래스를 각각 만들고 실행해보세요 (결과 출력)


		System.out.println("빼기");
		sub c1 = new sub() {
			@Override
			public double operate(double x, double y) {
				return x - y;
			}
		};
		result = c1.operate(1.0,2.0);
		System.out.println("result = " + result);
		System.out.println();

		System.out.println("곱하기");
		mul c2 = new mul() {
			@Override
			public double operate(double x, double y) {
				return x * y;
			}
		};
		result = c2.operate(1.0,2.0);
		System.out.println("result = " + result);
		System.out.println();

		System.out.println("나누기");
		div c3 = new div() {
			@Override
			public double operate(double x, double y) {
				return x / y;
			}
		};
		result = c3.operate(1.0,2.0);
		System.out.println("result = " + result);




	} // end main()

} // end class Anonymous02Main

interface Calculable{

	double operate(double x, double y);
}
/*
 위와 같이 특정 추상 메소드만 implement 하는 목적으로 설계되는 인터페이스의 이름은
 보통 ~ able 로 작명 경우가 많다.
 자바에서 제공하는 대표적으로 많이 사용하는 이러한 인터페이스들.
 Serializable, Cloneable, Readable, Appendable, Closeable,
 AutoCloseable, Observable, Iterable, Comparable, Runnable,
 Callable, Repeatable,  ...
*/


class TestMyMath implements Calculable{

	@Override
	public double operate(double x, double y) {
		return x + y;
	}
}

interface sub{
	double operate(double x, double y);
}

class subtraction implements sub{

	@Override
	public double operate(double x, double y) {
		return x - y;
	}
}

interface mul{
	double operate(double x, double y);
}

class multi implements mul{

	@Override
	public double operate(double x, double y) {
		return x * y;
	}
}

interface div{
	double operate(double x, double y);
}

class divide implements div{

	@Override
	public double operate(double x, double y) {
		return x / y;
	}
}