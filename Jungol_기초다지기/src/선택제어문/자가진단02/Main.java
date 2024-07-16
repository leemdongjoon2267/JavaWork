package 선택제어문.자가진단02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int weight, height;
        int Obesity;
        height = sc.nextInt();
        weight = sc.nextInt();
        Obesity = weight + 100 - height;
        System.out.println(Obesity);
        if (Obesity > 0) {
            System.out.print("Obesity");
        }
        sc.close();
    }
}
