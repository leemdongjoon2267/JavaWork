package 배열1.자가진단07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] minAr = new int[10];
        int[] maxAr = new int[10];

        for (int i = 0; i < 10; i++) {
            int n = sc.nextInt();

            if (n <= 100) {
                minAr[i] = n;
            } else {
                maxAr[i] = n;
            }
        }

        //100미만중 가장 큰 수
        for (int i = 1; i < 10; i++) {
            if (minAr[i - 1] < minAr[i]) {
                minAr[i] = minAr[i];
            }
            if (minAr[i - 1] > minAr[i]) {
                minAr[i] = minAr[i - 1];
            }
        }
        if(minAr[9] == 0) {
            minAr[9] = 100;
        }
        System.out.print(minAr[9] + " ");

        //100이상 가장 작은 수
        for(int i = 0; i < 10; i++) {
            if (maxAr[i] == 0) {
                maxAr[i] = 1001;
            }
        }
        for(int i = 1; i < 10; i++) {
            if (maxAr[i - 1] < maxAr[i]) {
                maxAr[i] = maxAr[i - 1];
            }
        }
        if(maxAr[9] == 1001) {
            maxAr[9] = 100;
        }
        System.out.println(maxAr[9]);

    }
}
