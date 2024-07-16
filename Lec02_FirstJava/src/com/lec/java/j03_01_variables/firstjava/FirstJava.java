package com.lec.java.j03_01_variables.firstjava;

public class FirstJava {
    public static void main(String[] args) {
        System.out.println(123); // Ctrl+d하면 그대로 복사해서 줄바꿈
        System.out.println("123");

        System.out.println(10 + 20);
        System.out.println("10 + 20");

        System.out.println(3.141592 * 10 * 10); // 실수와의 연산결과는 무.조.건 '실수'
        System.out.println(10 / 2);
        // "문자열" + 숫자 => 문자열
        //           ↓ 문자열 변환
        // "문자열" + "숫자" => 문자열
        System.out.println("결과 : " + 10);
        System.out.println("결과 : " + 10 + 20); // 숫자 10, 20이 문자열로 바뀜
        System.out.println("결과 : " + (10 + 20)); // 괄호로 인해 숫자 + 숫자로 진행, 결과도 숫자

        System.out.println("10 + 20 = " + (10 + 20));
        System.out.println("10 - 20 = " + (10 - 20));
        System.out.println("10 * 20 = " + (10 * 20));
        System.out.println("10 / 20 = " + (10 / 20)); // 정수와 정수 간의 연산 결과는 '정수'

        System.out.println("10 / 20 = " + (10 / 20.0));
        System.out.println("10 / 20 = " + (10. / 20));
        // (double)10 => 10이라는 정수를 10.0 실수로 변환
        System.out.println("10 / 20 = " + ((double)10 / 20));

        //println(), print()
        System.out.print("안녕");
        System.out.print("하세요");
        System.out.println("Good morning");

        // 이스케이프 문자 (escape character)
        // " ~ " 문자열 안에서 특수 문자 출력


        // 입문시 기억할만한 이스케이프 문자
        // \"  : 쌍따옴표
        // \n  : 줄바꿈
        // \t  : 탭문자
        // \\  : 문자열 안에서 역슬래시 출력

        // She says "Hi" <-- 출력하려면?
        System.out.print("She says \"Hi\"");

        System.out.println("1234567890");
        System.out.println("123\n456\n7890"); // 출력중 줄바꿈
        System.out.println("123\t456\t789"); // 4칸 단위로 띄어쓰기
        System.out.println("12\t45\t78");
        System.out.println("자바\\웹개발"); // \하나출력

    }
}
