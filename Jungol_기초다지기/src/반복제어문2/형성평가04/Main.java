package 반복제어문2.형성평가04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int sum = 0;
        float avg = 0;

        for(int i = 0; i < number; i++ ) {
            int number2 = scanner.nextInt();

            sum += number2;
        }
        avg = (float)sum / number;

        System.out.printf("%.2f", avg);

        scanner.close();
    }
}
