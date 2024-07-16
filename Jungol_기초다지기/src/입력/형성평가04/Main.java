package 입력.형성평가04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int a = sc.nextInt(); // Integer.parseInt(sc.next());
        int b = sc.nextInt();
        int c = sc.nextInt();

        int sum = a + b + c;
        System.out.println("sum = " + sum);

        sc.close();

    }
}
