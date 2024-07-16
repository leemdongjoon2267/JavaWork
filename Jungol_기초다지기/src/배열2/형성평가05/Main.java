package 배열2.형성평가05;

/*
164 : 배열2 - 형성평가5


[문제]
호석이네 학교는 6학년이 네 반이 있는데 각 반의 대표를 세 명씩 선발하여 제기차기 시합을 하였다.
반별로 세 명이 제기를 찬 개수를 입력받아 각 반별로 제기를 찬 개수의 합계를 출력하는 프로그램을 작성하시오.
(반드시 배열을 이용하고 입력후에 출력하는 방식으로 하세요.)

[입력예]
1class? 15 2 35
2class? 33 1 6
3class? 5 10 19
4class? 1 8 55


[출력예]
1class : 52
2class : 40
3class : 34
4class : 64

[입력예]
72 67 49
97 42 38
59 2 18
81 16 86

[출력예]
1class : 188
2class : 177
3class : 79
4class : 183
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[4][3]; // 4개반 x3 학생
        int[] sum = new int[4]; // 4개반의 제기차기 합계점수를 구하는 1차원 배열
        for(int ban = 0; ban< arr.length; ban++){
            System.out.print((ban + 1) + "class? ");

            for(int stu = 0; stu < arr[ban].length; stu++){
                arr[ban][stu] = sc.nextInt();
                sum[ban] += arr[ban][stu];
            }
        }
        for(int ban = 0; ban < sum.length; ban++){
            System.out.println((ban + 1) + "class : " + sum[ban]);
        }

        sc.close();
    }
}
