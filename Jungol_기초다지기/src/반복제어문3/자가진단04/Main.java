package 반복제어문3.자가진단04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i;
        int j;
        int k;

        for(i = 0; i < n; i++) {
            for (k = 0; k < i; k++)
                System.out.print(" ");

            for (j = n; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();

            sc.close();
        }
    }
}

/*

 ***
 **
 *

 */