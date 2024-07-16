package 선택제어문.자가진단09;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num1, num2, num3;

        num1 = sc.nextInt();
        num2 = sc.nextInt();
        num3 = sc.nextInt();

        int min = (num1 <= num2 && num1 <= num3) ? num1 : ((num2 <= num1 && num2 <= num3) ? num2 : num3);

        System.out.println(min);
        sc.close();
    }
}
