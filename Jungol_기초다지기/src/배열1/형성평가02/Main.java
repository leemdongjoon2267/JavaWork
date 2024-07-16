package 배열1.형성평가02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = new int[5];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(arr[0] + arr[2] + arr[4]);

        sc.close();
    }
}
