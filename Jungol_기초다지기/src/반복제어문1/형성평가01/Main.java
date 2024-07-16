package 반복제어문1.형성평가01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int i = 1;
        int n = sc.nextInt();

        while(i <= n){
            System.out.print(i + " ");
            i++;
        }
        sc.close();
    }
}
