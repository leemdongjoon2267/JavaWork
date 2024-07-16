package 배열1.형성평가05;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double sum = 0;

        double arr[] = new double[6];

        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextDouble();
            sum += arr[i];
        }
        System.out.printf("%.1f", sum / 6);

        sc.close();
    }
}
