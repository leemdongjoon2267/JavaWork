package 배열2.자가진단06;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[5][4];
        int[] sum = new int[5];
        int[] avg = new int[5];
        int cnt = 0;

        for(int stu = 0; stu < arr.length; stu++){
            for(int score = 0; score < arr[stu].length; score++){
                arr[stu][score] = sc.nextInt();
                sum[stu] += arr[stu][score];
            }
            avg[stu] = sum[stu]/4;
        }

        for(int stu = 0; stu < sum.length; stu++){
            if(avg[stu] >= 80){
                System.out.println("pass ");
                cnt++;
            }else{
                System.out.println("fail ");
            }
        }
        System.out.println("Successful : " + cnt);

        sc.close();
    }
}
