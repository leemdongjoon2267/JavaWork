package 선택제어문.자가진단07;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char Alphabet = sc.next().charAt(0);
        if(Alphabet == 'A'){
            System.out.println("Excellent");
        }else if(Alphabet == 'B'){
            System.out.println("Good");
        }else if(Alphabet == 'C'){
            System.out.println("Usually");
        }else if (Alphabet == 'D') {
            System.out.println("Effort");
        }else if(Alphabet == 'F'){
            System.out.println("Failure");
        }else{
            System.out.println("error");
        }
        sc.close();

    }
}
