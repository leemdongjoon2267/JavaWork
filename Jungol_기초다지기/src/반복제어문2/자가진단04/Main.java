package 반복제어문2.자가진단04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;
        if(n <= 100){
            for(int i = n; i <=100; i++){
                sum += i;
            }
        }
        System.out.println(sum);

        sc.close();
    }
}
