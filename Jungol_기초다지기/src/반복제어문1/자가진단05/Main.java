package 반복제어문1.자가진단05;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        while(true){
            n = sc.nextInt();
            if(n %3 ==0){
                System.out.println(n / 3);
            }
            if(n == -1){
                break;
            }
        }
        sc.close();
    }
}
