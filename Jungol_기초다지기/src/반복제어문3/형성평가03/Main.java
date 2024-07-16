package 반복제어문3.형성평가03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();

        // i : 행, j : 열
        // 증가
        for(int i = 0; i < n; i++){ // n개의 행
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 감소
        for(int i = 0 ; i < n - 1; i++){ // n-1개의 행
            for(int j = 0; j < n - 1 - i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}


// 다른 방법
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//
//        Scanner sc= new Scanner(System.in);
//        int n = sc.nextInt();
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j <= i; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        for(int i = 1 ; i < n; i++){
//            for(int j = n-1; j > i-1; j--){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//        sc.close();
//    }
//}

/*

 *
 **
 ***
 **
 *

 */