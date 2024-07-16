package 선택제어문.형성평가01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1, num2;
        num1 = sc.nextInt();
        num2 = sc.nextInt();

        int diff = (num1 > num2 ? (num1 - num2):(num2 -num1));
        System.out.println(diff);
        sc.close();
    }
}
