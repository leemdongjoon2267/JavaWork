package 선택제어문.자가진단06;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char gender;
        int age;
        gender = sc.next().charAt(0); // 중요하니까 복습
        age = sc.nextInt();

        if(gender == 'M' && age >= 18){
            System.out.println("MAN");
        }else if(gender == 'M' && age < 18){
            System.out.println("BOY");
        } else if(gender == 'F' && age >=18){
            System.out.println("WOMAN");
        }else if(gender == 'F' && age < 18) {
            System.out.println("GIRL");
        }
        sc.close();
    }
}
