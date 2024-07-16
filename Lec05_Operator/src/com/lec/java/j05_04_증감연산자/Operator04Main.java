package com.lec.java.j05_04_증감연산자;

/* 증감 연산자(++, --) Increment / Decrement Operator
 *  	++변수: 변수의 값을 1 증가시켜서 저장
 *   	--변수: 변수의 값을 1 감소시켜서 저장
 *
 *   증감연산자: prefix(접두사), postfix(접미사)
 *   	접두사(prefix)인 경우에는, 증감(++, --)이 먼저 된 후 다른 연산자가 동작
 *   	접미사(postfix)인 경우에는, 다른 연산자 먼저 실행된 후 증감(++, --)가 동작
 */
public class Operator04Main {

    public static void main(String[] args) {
        System.out.println("연산자 4 - 증감 연산자(++, --) Increment / Decrement Operator");

        int num1 = 100;
        ++num1;
        // num1 = num1 +1;
        // num1 += 1;
        System.out.println(num1);

        int num2 = 99;
        --num2; //prefix
        num2--; //postfix
        System.out.println(num2);

        {
            int num4 = 100;
            int num5 = ++num4; // 대입연산자보다 먼저 수행
            // 접두사(prefix)인 경우에는, 증감(++, --)이 먼저 된 후 다른 연산자가 동작
            // (1) num4의 값이 1 증가
            // (2) 증가된 num4의 값이 num5에 저장
            System.out.println("num4 = " + num4); // 101
            System.out.println("num5 = " + num5); // 101
        }

        {
            int num4 = 100;
            int num5 = num4++; // 대입연산자보다 나중에 수행
            // 접미사(postfix)인 경우에는, 다른 연산자 먼저 실행된 후 증감(++, --)가 동작
            // (1) 처음 num4의 값(100)이 먼저 num5에 저장
            // (2) 그 다음에 num4의 값이 1 증가
            System.out.println("num4 = " + num4); // 101
            System.out.println("num5 = " + num5); //100
        }

        {
            // 증감연산자 사용시 가급적 연산식 내에서 사용하지말고, 따로 독립적인 문장으로 작성 권장
            int num4 = 100;
            num4++;
            int num5 = num4;
            System.out.println("num4 = " + num4); // 101
            System.out.println("num5 = " + num5); //100
        }

        System.out.println("\n\n======================");
        System.out.println("증감연산자: prefix(접두사), postfix(접미사)");

        // TODO


        System.out.println("\n프로그램 종료");
    } // end main

} // end class












