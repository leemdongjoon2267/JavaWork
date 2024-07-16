package practice.capitalize;


import java.util.Arrays;
import java.util.Scanner;


/* LetterCapitalize
 *  주어진 문자열에서, 공백으로 구분된 각 단어의 앞 문자만 대문자로 만들기
 *
 *  [입력예]
 *     hello my WORLD
 *  [출력예]
 *     Hello My World
 */


public class LetterCapitalize {


	public static final String[] input = {
			"i am a PROGRAMMER",     // -> I Am A Programmer
			"THAT ELEPHANT IS BIG",  // -> That Elephant Is Big
	};


	public static void main(String[] args) {


		for(var x : input){
			System.out.println(letterCapitalize(x));
		}


	} // end main()


	//  toLowerCase, split(), charAt(), slice(), toUpperCase, concat, join() 등 사용
	public static String letterCapitalize(String str){

		// 문장을 단어 단위로 잘라서 배열에 저장
		String[] arr = str.toLowerCase().split(" "); // \t 사용
		String result = " ";
		for (int i = 0; i < arr[i].length(); i++) {

			arr[i] = arr[i].substring(0, 1).toUpperCase().concat(arr[i].substring(1));
			// 각 단어 맨 앞 글자를 추출 후 대문자로 변환 하고 나머지 뒷부분하고 연결
		}

		// 결과 저장 후 반환
		result = String.join(" ", arr);
		return result;
	}  // end letterCapitalize()


} // end class





