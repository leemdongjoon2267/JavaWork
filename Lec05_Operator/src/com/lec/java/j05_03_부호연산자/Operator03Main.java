package com.lec.java.j05_03_부호연산자;

/* 부호연산자(+, -) sign operator
 * 	+: 부호 연산자(수의 부호(양,음)가 바뀌지 않음)
 * 	-: 부호 연산자(수의 부호(양,음)가 바뀜)
 */
public class Operator03Main {

    public static void main(String[] args) {
        System.out.println("연산자 3 - 부호연산자(+, -) sign operator");

        int num1 = -10;
        int num2 = +num1; // -10
        int num3 = -num1; // 10

        int num4 = 11;
        int num5 = -22;

        int num6 = num4 + -num5;
        System.out.println(num6);

        int num7 = num4 - -num5; // 이 부분은 띄어쓰기 안하면 오류남 --num5가 되어버림
        System.out.println(num7);

        // CTRL + ALT + L : Reformat Code 활용 (들여쓰기, 띄어쓰기 정리)


        System.out.println("\n프로그램 종료");
    } // end main

} // end class













