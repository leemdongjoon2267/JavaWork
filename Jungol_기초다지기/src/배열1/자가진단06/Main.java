package 배열1.자가진단06;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n[] = new int[10];
        int min = 1000;
        int num = 0;

        for (int i = 0; i < n.length; i++) {
            num = sc.nextInt();
            n[i] = num;
            if (n[i] < min) {
                min = n[i];
            }
        }
        sc.close();
        System.out.println(min);
    }
}
