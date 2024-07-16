package 배열1.형성평가07;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = new int[100];
        int i, n;

        for(i = 0; i < arr.length; i++){
            n = sc.nextInt();
            if(n == 999) break;
            arr[i] = n;
        }
        int min = 999999;
        int max = -999999;
        for(int j = 0; j < i; j++){
            min = arr[j] > min ? min : arr[j];
            max = arr[j] < max ? max : arr[j];
        }

        System.out.println("max : " + max);
        System.out.println("min : " + min);

        sc.close();
    }
}
