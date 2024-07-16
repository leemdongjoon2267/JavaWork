package com.lec.java.j03_01_variables.hello;
/*
모든 자바 프로그램은 main()메소드로부터 시작한다

 */

/*
프로그램 실행순서는 '시작' 부터 한 문장(Statement) 씩 실행되는 것이 원칙
문장의 끝은 반드시 세미콜론 ';' 으로 마무리 해야 한다
*/


public class Hello {
    // 한줄 주석. Line comment
//    프로그램 실행과는 상관없지만
//    개발자가 프로그램을 작성할 때 설명을 달아주는 것
    public static void main(String[] args) {
        System.out.println("Hello Java");
        System.out.println("안녕하세요");
        System.out.println();
        System.out.println("자바");

        System.out.println(1 + 2); // 숫자 + 숫자 => 산술연산
        // " ~ " <- 문자열
        System.out.println("1 + 2"); // 문자열 + 문자열 => 문자열 연결
    }
}
