package 함수3.형성평가01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         calc(n);

        sc.close();
    }
    public static void calc(int n){
        if(n == 0) return; // 재귀함수 탈출 조건
        calc (n / 2);
        System.out.print(n + " ");
    }
}
