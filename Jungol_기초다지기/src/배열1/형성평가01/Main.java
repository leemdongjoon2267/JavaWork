package 배열1.형성평가01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String arr[] = new String[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.next();
            String str = arr[i];
        }
        for(int i = arr.length-1; i >=0 ; i--){
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
