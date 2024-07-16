package 배열1.자가진단04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100];
        int i;
        for(i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
            if(arr[i] == 0){
                for(int j = 1; j <= i; j++){
                    System.out.print(arr[i-j] + " ");
                }
                break;
            }
        }

        sc.close();
    }
}
