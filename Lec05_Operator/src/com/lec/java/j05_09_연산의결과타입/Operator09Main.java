package com.lec.java.j05_09_연산의결과타입;
/* 산술 연산의 결과 타입
 * 
 * 일단 피연산자가 reference type 이면, unbox 후 형변환 수행됨. 그리고 나서
 * 피연산자중 하나라도 double 이면 다른쪽이 double 이 된다.  
 * 그렇지 않으면 피연산자중 하나라도 float 이면 다른 쪽이 float 가 된다.  
 * 그도 아니면 피연산자중 하나라도 long 이면 다른 쪽을 long 으로 바꾼다.  
 * 그도 아니면 양쪽 피연산자 모~ 두 int 로 바꾼다.
 * 
 * https://docs.oracle.com/javase/specs/#5.6.2
 * 	When an operator applies binary numeric promotion to a pair of operands, each of which must denote a value that is convertible to a numeric type, the following rules apply, in order, using widening conversion (§5.1.2) to convert operands as necessary: 
 * 	If any of the operands is of a reference type, unboxing conversion (§5.1.8) is performed. Then: 
 * 	If either operand is of type double, the other is converted to double. 
 * 	Otherwise, if either operand is of type float, the other is converted to float. 
 * 	Otherwise, if either operand is of type long, the other is converted to long. 
 * 	Otherwise, both operands are converted to type int.
 */
public class Operator09Main {

	public static void main(String[] args) {
		System.out.println("산술연산의 결과 타입");

		int n1 = 10, n2 =20;
		int n3 = n1 + n2;
		System.out.println("n3 : " +n3);

		byte b1 = 10, b2 = 20;
//		byte b3 = b1 + b2; // byte + byte의 결과는 int
		byte b3 = (byte)(b1 + b2); // 명시적 형변환으로 가능

		long l1 = 10L;
//		int n4 = n1 + l1; // int + long = long

		short s1 = 100;
//		short s2 = s1 + b1; // short + byte = int


		float f1 = 1.0f, f2 = 2.0f;
		float f3 = f1 + f2; // float + float = float

//		float f4 = f1 + 2.0; // float + double = double

		// int 이하 산술연산결과가 무.조.건 int 이기 때문에  주의 할 사항
		long l2 = 27_000_000_000L; // 3000 * 3000 * 3000
		System.out.println("l2 : " + l2);

		l2 = 3000 * 3000 * 3000; // 오버플로 발생
		System.out.println("l2 : " + l2);

		System.out.println("\n 프로그램 종료");
	} // end main ()
} // end class

/**
 * Debug (디버깅)
 *     : 프로그램의 '논리적 오류' 를 찾아내기 위한 작업
 *     : "프로그램의 실력은 곧 디버깅 실력이다!"
 *
 *  step1 : breakpoint 설정  (CTRL + F8)  (목록: CTRL+SHIFT+F8)
 *  step2 : debug 시작       (SHIFT + F9)
 *          breakpoint 를 만나면 프로그램 실행이 일시 중단된다 -> step3 로
 *  step3 :
 *      step over : 한 단계씩 명령 실행 (F8)
 *      resume : 다음 breakpoint 까지 진행 (F9)
 *
 *      확인해야 하는 것들
 *     1) 프로그램의 흐름
 *     2) 변수값의 변화
 *     3) 호출관계 흐름
 *
 *  step4 : debug 종료 (terminate)  (CTRL+F2)
 *
 */



