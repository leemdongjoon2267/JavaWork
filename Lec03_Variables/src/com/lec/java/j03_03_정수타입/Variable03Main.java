package com.lec.java.j03_03_정수타입;

/**
 * 자바의 기본 자료형(primitive data type)
 * 정수 타입: byte(1바이트), short(2바이트), int(4바이트), long(8바이트)
 * 실수 타입: float(4바이트), double(8바이트)
 * 문자 타입: char(2바이트)
 * 논리 타입: boolean(1바이트)
 */

public class Variable03Main {

    public static void main(String[] args) {

        System.out.println("정수 타입 변수들");

        System.out.println("byte : " + Byte.MIN_VALUE + " ~ " +Byte.MAX_VALUE);
        byte num1 = -128;
        byte num2 = 0;
        byte num3 = 123;
//        byte num4 = 1234; // byte 가 담을 수 있는 용량 밖의 값 대입 불가

        System.out.println("short : " + Short.MIN_VALUE + " ~ " +Short.MAX_VALUE);
        short num5 = -1234;
        short num6 = 12345;
//        short num7 = 32768;

        System.out.println("int : " + Integer.MIN_VALUE + " ~ " +Integer.MAX_VALUE);
        System.out.println("long : " + Long.MIN_VALUE + " ~ " +Long.MAX_VALUE);

//        int num9 = 9876543210;
//        long num10 = 9876543210;

        // 리터럴(literal) : 코드에 직접 입력하는 값.
        // 리터럴도 '타입'이 있다.
        // 자바는 기본적으로
        //   정수타입리터럴을 int 타입으로 인식하려 한다.
        //   실수타입리터럴을 double 타입으로 인식하려 한다.

        long num11 = 9876543210L;
        // 9876543210 이라는 숫자 리터럴이 int 타입이 아니라 long 타입 리터럴임을 명시하기 위해서
        // 숫자 뒤에 영문자 L을 붙여줌
        // 자바에서 정수 타입 변수의 기본은 int임.
        // 자바는 정수 숫자(리터럴)를 별도 표기가 없으면 int라고 생각.

        long num12 = 12; // 12라는 int 값을 Long 타입에 대입(자동형변환)
        long num13 = 12L; // 12라는 Long 값을 Long 타입에 대입
        int num14 = 12;
//        int num15 = 12L; // Long 타입 리터럴을 int에 대입 불가

        byte num15 = Byte.MAX_VALUE; // +127
        byte num16 = (byte)(num15 + 1);

        // 정수타입은 값의 경계선에서
        // overflow, underflow 발생
        System.out.println("num15 = " + num15); // 127
        System.out.println("num16 = " + num16); // -128

        // 진법에 따를 리터럴 표기
        int number1 = 11;
        int number2 = 0xB; // 16진수 리터럴 : 0x로 시작
        int number3 = 013; // 8진수 리터럴 : 0으로 시작
        int number4 = 0b1011; // 2진수 리터럴 : 0b로 시작

        System.out.println("number1 = " + number1);
        System.out.println("number2 = " + number2);
        System.out.println("number3 = " + number3);
        System.out.println("number4 = " + number4);


    } // end main()
} // end class
