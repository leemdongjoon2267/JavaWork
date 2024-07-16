package com.lec.java.j12_12_variable_args;

/*  가변인자 (가변매개변수,가변인수) Variable arguments
   Java 5.0 부터 등장
     매개변수(argument, 인자)의 개수를 가변적으로 조정하는 기술
     ** 가변인자 기술이 없던 시절에는 '컬렉션' 사용.

     컴파일러에서 가변인자를 아래와 같이 변환해준다.
  
   1) 매개변수를 배열로 변환해준다
        원본 : public static void display(String... args)
        컴파일러 변환 후 : public static void display(String args[])
  
   2) 메소드 호출시 인자들을 이용해서 배열로 만들어 준다
        원본 : VarArgsMain.display("Hello", "World", "Korea");
        컴파일러 변환 후 : VarArgsMain.display(new String[] {"Hello", "World", "Korea" })
*/

import java.util.Arrays;

public class Method12Main {

	public static void main(String[] args) {
		System.out.println("가변인자 (가변매개변수,가변인수) Variable arguments");

		display("홍길동");
		display("최은정", "김예현", "김세진"); // 가변 매개변수를 받아서 에러 해결
		display("한정우", "진민장");
		display("심의선", "서해성", "최민혁", "정준영");


		System.out.println("\n프로그램 종료");
	} // end main()
	
	
	public static void display(String arg){

		System.out.println(arg);

	}

	// 가변 매개변수
	public static void display(String... arg){
		System.out.println("가변인자 개수는: " + arg.length);
		System.out.println(Arrays.toString(arg));
	}
	
	
} // end class










