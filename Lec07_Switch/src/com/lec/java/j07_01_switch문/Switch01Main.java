package com.lec.java.j07_01_switch문;

/* switch - case 조건문
 * 
 * 	switch (조건값){
 * 	case 값1:
 * 		...
 * 	case 값2:
 * 		...
 *	default:
 *		...
 *	}
 *
 * 	해당 조건의 case문을 찾아서 거기서부터 break를 만날 때까지 실행을 함.
 *  break를 만나게 되면 switch 문장을 종료.
 *  해당하는 case가 없으면 default 문장을 실행함.
 *  
 *  	※ 모든 switch 조건문은 if - else if - else로 바꿀 수 있다. (할수 있어야 한다)
 */
public class Switch01Main {

	public static void main(String[] args) {
		System.out.println("switch 문");

		int num = 3;

		switch (num){
			case 1 : // num 값이 1인 경우 수행
				System.out.println("하나");
				System.out.println("ONE");
				break; // break 만나면 switch 종료

			case 2 : // num 값이 2인 경우 수행
				System.out.println("둘");
				System.out.println("TWO");
				break;

			case 3 : // num 값이 3인 경우 수행
				System.out.println("셋");
				System.out.println("THREE");
				break;

			default :
				System.out.println("몰라요~");

		} // end switch
		
		System.out.println();
		// 모든 switch 조건문 if - else if - else로 바꿀 수 있다.
		if (num == 1) {
			System.out.println("하나");
			System.out.println("ONE");
		} else if (num == 2) {
			System.out.println("둘");
			System.out.println("TWO");
		} else if (num == 3) {
			System.out.println("셋");
			System.out.println("THREE");
		} else {
			System.out.println("몰라요~");
		}



		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










