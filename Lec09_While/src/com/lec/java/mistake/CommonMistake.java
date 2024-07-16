package com.lec.java.mistake;

public class CommonMistake {

    public static void main(String[] args) {

        int n = 34;

        if(n % 2 == 1); // if, for, while ... 뒤에 곧바로 ; 붙이는 실수 주의
            System.out.println("홀수입니다");

        final boolean GOOD = true;
        final boolean BAD = false;

        boolean john = BAD;

        if(john = GOOD) // 대입연산을 사용해서 결과가 "착한애"로 나옴 비교연산으로 해야함 "=="
            System.out.println("착한애");
        else
            System.out.println("나쁜애");
    }
}
