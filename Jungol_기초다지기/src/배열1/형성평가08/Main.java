package 배열1.형성평가08;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int i,a, count = 0;
        double sum = 0.0;
        int[] arr= new int[100];
        for(i = 0; i < arr.length; i++){
            a = sc.nextInt();
            if(a == 0) break;
            arr[i] = a;
        }

        for(int j = 0; j < i; j++){
            if(arr[j] % 5 == 0) {
                sum += arr[j];
                count++;
            }
        }
        System.out.println("Multiples of 5 : " + count);
        System.out.println("sum : " + (int)sum);
        System.out.printf("avg : %.1f", sum/count);

        sc.close();
    }
}
