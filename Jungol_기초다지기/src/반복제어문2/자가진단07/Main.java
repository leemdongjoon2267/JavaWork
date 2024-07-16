package 반복제어문2.자가진단07;

public class Main {

    public static void main(String[] args) {
        for(int i = 1; i <= 5;  i++) {
            for(int j = i + 1; j < i + 6; j++) {
                System.out.printf("%d ", j);
            }System.out.println(" ");
        }
    }
}
