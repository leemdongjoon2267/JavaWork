package 배열1.형성평가06;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[] arr =  {'J', 'U', 'N', 'G', 'O', 'L'};
        int i;
        char ch = sc.next().charAt(0);
        boolean a = true;
        for(i = 0; i < 6; i++){
            if(arr[i] == ch){
                a = false;
                break;
            }
        }
        if(a) System.out.println("none");
        else System.out.println(i);
        sc.close();
    }
}
