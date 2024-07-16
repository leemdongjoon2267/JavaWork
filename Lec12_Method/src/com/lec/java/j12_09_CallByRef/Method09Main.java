package com.lec.java.j12_09_CallByRef;

/*  Call By Value : 값에 의한 호출
 	Call By Reference : 참조에 의한 호출
 	
 	메소드 호출시 매개변수에 넘겨주는 값의 '복사' 가 발생.
 	
 	자바에선
 	primitive type 이 매개변수 인 경우 Call By Value
 	 		: '값' 이 복사된다 
 	 		: 메소드에서 매개변수 값을 변경해도 호출한 원본 쪽은 변화 없슴
 	 		
 	reference type 이 매개변수 인 경우 Call By Reference 발생
 			: '값' 이 복사된다. (주솟값 ★)
 			: 메소드에서 매개변수 를 통해 변경하면 호출한 원본 쪽도 변화 발생
 	
 */
public class Method09Main {

	public static void main(String[] args) {
		System.out.println("Call By Value : 값에 의한 호출");
		System.out.println("Call By Reference : 참조에 의한 호출");

		int n = 10;
		incNum(n);
		System.out.println("incNum(n) 호출후 n: " + n);

		int[] arr = {10};
		incNum(arr);
		System.out.println("incNum(arr) 호출후 arr[0]: " + arr[0]);


		System.out.println("\n프로그램 종료");
	} // end main()

	// 오버로딩
	private static void incNum(int[] arr) {
		arr[0]++; // stack 에 있는 메인 지역변수 값이 heap 을 참조함
		// 호출할때 메인메소드 변수값이 매개변수로 복사됨 따라서 똑같은 객체를 가지게됨
		// 따라서 arr[0]과 호출후 arr[0]의 값은 11로 같음
		// Call By Reference
		System.out.println("incNum(int[]): " + arr[0]);
	}

	private static void incNum(int n) {
		n++; // incNum 의 n 값을 증가시키지만 메인으로 리턴할때 사라져서 메인에서 호출후 n 값은 10으로 돌아옴
		// Call By Value
		System.out.println("incNum(n): " + n);
	}


} // end class
