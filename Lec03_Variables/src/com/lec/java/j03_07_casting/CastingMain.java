package com.lec.java.j03_07_casting;

public class CastingMain {
    /*
     * 암묵적 형변환(Implicit casting): 자바 언어가 자동으로 해주는 형변환
     *
     *     primitive type 에서 implicit casting 방향
     *
     *     byte → short → int → long → float → double
     *                     ↑
     *                    char
     *
     * 명시적 형변환(Explicit casting): 프로그래머가 직접 타입을 변환하는 것
     *
     *      (변환하고자 하는 타입명)변수/값
     *
     *
     *
     */
    public static void main(String[] args) {
        // 암묵적 형변환(묵시적 형변환, 자동형변환)
        byte num1 = 123;
        //byte num2 = 512;

        short s1 = 123;
        int n1 = s1; // int <- short
        double d1 = n1; // double <- int

        char ch1 = 'A';
        //s1 = ch1; // short <- char(X)
        n1 = ch1; // int <- char

        // 명시적 형변환
        byte num5 = (byte)513; // 자료손실 발생
        System.out.println("num5 = " + num5); // 결과 1

        double agv1 = (99 + 88 + 78) / 3;
        System.out.println(agv1);

        double agv2 = (double)(99 + 88 + 78) / 3;
        System.out.println(agv2);

    } // end main()
} // end class
