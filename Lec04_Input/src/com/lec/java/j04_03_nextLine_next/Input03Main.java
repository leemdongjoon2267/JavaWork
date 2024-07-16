package com.lec.java.j04_03_nextLine_next;

import java.util.Scanner;

public class Input03Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String in;

        // > aaa, bbb, ccc <- 입력
        System.out.print("여러 단어의 문장을 입력하세요 > ");
        in = sc.nextLine();
        System.out.println("in : " + in);

        // next()
        // 다음 단어(token) 을 받아서 String 으로 리턴한다
        System.out.print("여러 단어의 문장을 입력하세요 > ");
        in = sc.next();
        System.out.println("in : " + in); // 결과 : aaa

        // 다음것(token)을 입력받으려 할때
        // 기존의 버퍼에 담겨 있는 내용들이 담긴다
        String in2 = sc.next();
        System.out.println("in2 : " + in2); // 결과 : bbb

        String in3 = sc.next();
        System.out.println("in3 : " + in3); // 결과 : ccc

        //숫자 타입도 여러개를 '한줄'에 받을수 있다.
        // > 100 3.14 300
        System.out.print("숫자 3개 (int, double, short)를 입력받으세요 >");
        int i1 = sc.nextInt();
        double d1 = sc.nextDouble();
        short s1 = sc.nextShort();

        System.out.printf("i1, d1, s1 : %d, %f, %d\n", i1, d1, s1); // 포매팅으로 출력

        sc.close();

    } // end main()
} // end class
