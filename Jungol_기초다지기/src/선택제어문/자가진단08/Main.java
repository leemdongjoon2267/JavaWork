package 선택제어문.자가진단08;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double score = sc.nextDouble();
        String result;

        switch ((int)score){
            case 5 :
            case 4 :
                result = "scholarship";
                break;

            case 3 :
                result = "next semester";
                break;

            case 2 :
                result = "seasonal semester";
                break;

            default :
                result = "retake";
        }
        System.out.println(result);
        sc.close();
    }
}
