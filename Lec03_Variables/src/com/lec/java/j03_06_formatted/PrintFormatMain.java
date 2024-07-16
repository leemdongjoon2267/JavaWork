package com.lec.java.j03_06_formatted;
/* 서식화된 문자열 (formatted string)
 *  ● 화면에 출력할때는 -> printf()
 *
 *    printf("서식문자열", 값1, 값2....)
 *
 *  ● 문자열(String)으로 만들때는 -> String.format()
 *
 *    String.format("서식문자열", 값1, 값2....)
 *
 *  ● format specifier (서식 지정자)
 *      %d  :  십진수 정수로 출력
 *      %f  :  실수로 출력
 *      %s  :  문자열 출력
 *      %c  :  '문자하나' 출력
 *      %x  :  16진수 정수로 출력
 *      %%  :  % 출력
 */
public class PrintFormatMain {

    public static void main(String[] args) {

        double pi = Math.PI;
        System.out.println(pi);

        // printf : print with format
        // printf("서식문자열", 값1, 값2....)
        // 서식문자열 안에 %로 시작하는 서식문자들..

        System.out.printf("원주율 %f\n", pi); // %f : 실수 포맷으로 출력(소숫점 6자리까지)
        System.out.printf("원주율 %.2f\n", pi); // %.2f : (소숫점 2자리까지)

        int age = 10, grade = 3;

        System.out.printf("제 나이는 %d 살입니다. 학년은 %d학년 입니다.\n", age, grade); // 10진수 정수값으로 출력

        System.out.printf("%d, %x, %c\n", 65, 65, 65);

        // 출력폭 지정, 좌우정렬
        System.out.printf("|%5d|%5d|%5d|\n", 100, 200, 300); // 폭5칸, 우측정렬
        System.out.printf("|%-5d|%-5d|%-5d|\n", 100, 200, 300); // 폭5칸, 좌측정렬

        System.out.printf("|%6.1f|\n", 182.35); // 총 6자리, 소숫점 이하 1자리

        // String.format()
        // 기본적으로 printf() 와 사용법은 동일함
        // 단, 화면에 출력하는게 아니라, 결과를 문자열(String) 으로 만들어서 리턴
        String.format("합격률은 %.1f입니다.", 0.73); // 화면에 바로찍히는게 아님

        String result = String.format("합격률은 %.1f%%입니다.", 0.73);
        System.out.println(result);

        //Text Block으로 포매팅
        String textBlock = """
                {
                    "title" : %s,
                    "author" : %s,
                    "id" : %d
                }
                """.formatted("안녕", "김작가", 2); // 서식지정자에 포매팅을 통해 데이터가 들어감

        System.out.println(textBlock);

        System.out.println("프로그램 종료");

    } // end main()
} // end class
