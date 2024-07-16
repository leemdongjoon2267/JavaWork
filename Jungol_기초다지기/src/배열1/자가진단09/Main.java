package 배열1.자가진단09;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = new int[10];
        int n = 0;
        int temp = 0; // 임의
        for(int i = 0; i < arr.length; i++){
            n = sc.nextInt();
            arr[i] = n;
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length-1; j++){
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
