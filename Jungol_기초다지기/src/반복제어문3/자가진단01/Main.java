package 반복제어문3.자가진단01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int cnt = 0;
        for(int i = 1; sum < n; i++){
            if(i % 2 ==1){
                sum += i;
                cnt++;
            }
        }
        System.out.printf("%d %d", cnt, sum);
        sc.close();
    }
}
