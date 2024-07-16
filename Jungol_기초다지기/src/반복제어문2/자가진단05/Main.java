package 반복제어문2.자가진단05;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int multipleThree = 0;
        int multipleFive = 0;
        for(int i = 1; i <= 10; i++) {
            int n = sc.nextInt();

            if( n % 3 == 0 ) {
                multipleThree += 1;
            }

            if( n % 5 == 0 ) {
                multipleFive += 1;
            }
        }

        System.out.println("Multiples of 3 : " + multipleThree);
        System.out.println("Multiples of 5 : " + multipleFive);

        sc.close();
    }
}
