package 반복제어문1.형성평가05;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        double Base = 0, Height = 0;
        double width;
        char answer = 0;

        while(true){
            System.out.print("Base = ");
            Base = sc.nextDouble();
            System.out.print("Height = ");
            Height = sc.nextDouble();

            width = (Base * Height) / 2;
            System.out.printf("Triangle width = %.1f\n", width);

            System.out.print("Continue? ");

            answer = sc.next().charAt(0);
            if(answer == 'Y' || answer == 'y'){
                continue;
            }else{
                break;
            }
        }


        sc.close();
    }
}
