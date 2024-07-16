package 반복제어문2.자가진단03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if(n <= 50){
            for(int i = 1; i <= n; i++){
                if(i % 2 ==0){
                    System.out.print(i + " ");
                }
            }
        }
        sc.close();
    }
}
