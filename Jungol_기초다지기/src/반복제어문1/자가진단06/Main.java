package 반복제어문1.자가진단06;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Korea");
        System.out.println("2. USA");
        System.out.println("3. Japan");
        System.out.println("4. China");
        System.out.print("number? ");
        int n = sc.nextInt();
        System.out.println();
        while (true){
            if (n == 1) {
                System.out.println("Seoul");
                System.out.println();
            } else if (n == 2) {
                System.out.println("Washington");
                System.out.println();
            } else if (n == 3) {
                System.out.println("Tokyo");
                System.out.println();
            } else if (n == 4) {
                System.out.println("Beijing");
                System.out.println();
            } else {
                System.out.println("none");
                break;
            }
        }
        sc.close();
    }
}
