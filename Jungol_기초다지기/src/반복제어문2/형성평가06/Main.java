package 반복제어문2.형성평가06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();

        int sum = 0;
        float avg = 0;
        int count = 0;

        //입력 받은 숫자가 같을 경우 추가
        if(number1 <= number2) {
            for(int i = number1; i <= number2; i++) {

                if(i % 3 == 0 || i % 5 == 0) {
                    sum += i;
                    count++;
                }
            }
            avg = (float)sum / count;
        }

        if(number1 > number2) {
            for(int i = number2; i <= number1; i++) {

                if(i % 3 == 0 || i % 5 == 0) {
                    sum += i;
                    count++;
                }
            }
            avg = (float)sum / count;
        }
        System.out.printf("sum : %d\navg : %.1f", sum, avg);
    }
}
