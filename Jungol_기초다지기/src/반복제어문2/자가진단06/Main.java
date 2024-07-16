package 반복제어문2.자가진단06;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int subject = sc.nextInt();
        int score = 0;
        int sum = 0;
        int cnt = 0;
        double avg = 0;

        for(int i = 0; i < subject; i++) {
            score = sc.nextInt();
            sum += score;
            cnt++;
        }
        avg = (double)sum / cnt;
        System.out.printf("avg : %.1f\n", avg);
            if(avg >= 80.0){
                System.out.println("pass");
            }else{
                System.out.println("fail");
            }

        sc.close();
    }
}
