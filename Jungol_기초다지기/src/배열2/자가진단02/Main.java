package 배열2.자가진단02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] number = new int[10];

        while (true) {
            int inputNumber = sc.nextInt();

            if (inputNumber == 0) {
                break;
            }
            int a = inputNumber/10;
            number[a]++;
        }

        for (int i = 0; i < number.length; i++) {
            if (number[i] != 0) {
                System.out.println(i + " : " + number[i]);
            }
        }
        sc.close();
    }
}

