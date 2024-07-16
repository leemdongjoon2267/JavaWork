package 배열1.형성평가04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100];
        int i;
        for(i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
            if(arr[i] == -1) break;
        }
        int startIndex = (i - 3 >= 0) ? i - 3 : 0;
        // 길이가 짧을때 나는 오류(ArrayIndexOutOfBoundsException)
        // 해결을 위한 삼항연산자
        for(int n = startIndex; n < i; n++){
            System.out.print(arr[n] + " ");
        }

        sc.close();
    }
}
