package 반복제어문1.자가진단03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("number? ");
        int i;
        i = sc.nextInt();
        while(true){
            if(i > 0){
                System.out.println("positive integer");
            }else if(i < 0){
                System.out.println("negative number");
            }else if(i == 0){
                break;
            }
        }


        sc.close();
    }
}
