package 배열1.형성평가09;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = new int[100];
        int i,a;

        for(i = 0; i < 100; i++){
            a = sc.nextInt();
            if(a == 0) break;
            arr[i] = a;
        }

        System.out.println(i);
        for(int j = 0; j < i; j++){
            if(arr[j] % 2 == 1){
                System.out.print((arr[j] * 2) + " ");
            } else{
                System.out.print((arr[j] / 2) + " ");
            }
        }

        sc.close();
    }
}
