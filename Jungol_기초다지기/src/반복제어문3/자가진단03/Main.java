package 반복제어문3.자가진단03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0 ; i < n; i++){ // n-1개의 행
            for(int j = 0; j < n - i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 0; i < n; i++){ // n개의 행
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
/*

 ***
 **
 *
 *
 **
 ***

 */
