package 배열1.형성평가03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int odd = 0;
        int even = 0;
        int arr[] = new int[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < arr.length; i++){
            if((i + 1) % 2 == 0){
                even += arr[i];
            }else{
                odd += arr[i];
            }
        }
        System.out.println("odd : " + odd);
        System.out.println("even : " + even);

        sc.close();
    }
}
