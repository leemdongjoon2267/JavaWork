package com.lec.java.j03_02_variables;

/*
   변수명 등 사용자가 이름을 지어준것들 --> 식별자 (identifier) 라고 함.

   식별자 수정할때는 refactor-rename 기능을 활용하자. (Shift + F6)
*/

public class VariableMain {

    public static void main(String[] args) {
        int number;

        int num1 = 10; // 선언과 동시에 초기화

        int kor = 50;
        int eng = 62;
        int math = 33;

        System.out.println("총점 : " +(kor +eng + math));

        int total;
        total = kor + eng +math;
        System.out.println("total : " + total );

        System.out.println("평균 : " + ((double)total/3));

        // 변수명 (식별자) 작명 제약사항.
        // 알파벳, 숫자, _, $
        // 숫자로 시작하면 안됨
        // 띄어쓰기 안됨
        // 대소문자 구분
        // 중복 안됨.
        int abc;
//        int abc;

        int Abc;

        int year2020;
//        int 2020year;

//        int year 2024;

        int myLittleToy; // 자바에서는 일반적으로 camel-notation 관례에 따라 변수병 작명
        int my_little_toy;

        int _my_toy_;
        int $aa;

    } // end main()
} // end class
