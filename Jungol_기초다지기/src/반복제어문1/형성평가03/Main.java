package 반복제어문1.형성평가03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        int sum = 0, cnt = 0;  // '합계' , '개수'

        while(true){
            n = sc.nextInt();
            if(n < 0 || 100 < n) break;   // 종료조건
            sum += n;  // 합계 누적
            cnt++;    // 입력 개수 증가
        }

        // 결과 출력
        System.out.println("sum : " + sum);
        System.out.printf("avg : %.1f", (double)sum / cnt); // 실수로 나누는 조건

        sc.close();


    }
}
