package 배열1.자가진단03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] arr = new char[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.next().charAt(0);
        }
        System.out.print(arr[0] + " ");
        System.out.print(arr[3] + " ");
        System.out.print(arr[6]);

        sc.close();
    }
}
