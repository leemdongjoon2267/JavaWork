package practice.game369;


import java.util.Scanner;

public class Game369Main {

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			boolean contains369 = false;
			int num = i;
			while (num > 0) {
				int count = num % 10;
				if (count == 3 || count == 6 || count == 9) {
					contains369 = true;
					break;
				}
				num /= 10;
			}

			if (contains369) {
				System.out.print("* ");
			} else {
				System.out.print(i + " ");
			}
		}

	} // end main()

} // end class Game369Main








