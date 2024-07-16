package 배열1.자가진단08;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = new int[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int sum = 0, avg = 0;
        for(int i = 0; i < 10; i++){
            if(i % 2 == 1){
                sum += arr[i];
            }else{
                avg += arr[i];
            }
        }

        System.out.println("sum : " + sum);
        System.out.println("avg : " + String.format("%.1f", avg / 5.0));

        sc.close();
    }
}
