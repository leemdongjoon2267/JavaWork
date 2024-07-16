package com.lec.java.j19_15_대표적인정규표현식;

import java.util.regex.Pattern;

/* 대표적인 정규 표현식 
 *  구글링 하면 대표적인 정규표현식들이 많이 구할수 있습니다.
 *  각 정규표현식들을 작성해보고
 *	매칭되는 문자열과 그렇지 않은 것들을 출력해봅시다.   
 */
public class RegExp05Main {

	public static void main(String[] args) {
		System.out.println("많이 쓰는 정규표현식");

		String regex, intput, title;
		String [] arrInput;
		
		//─────────────────────────────────────────
		title = "URL";
		regex = "(?<!https?:\\\\/\\\\/)https?:\\\\/\\\\/[a-zA-Z0-9\\\\-\\\\.]+\\\\.[a-zA-Z]{2,}(\\\\S*)?";
		arrInput = new String[] {
			"https://www.naver.com",
				"google.com",
				"http://www.daum.com",
				"http://jungol.com",
				"https://naver.co.kr"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		
		//─────────────────────────────────────────
		title = "email";
		regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		arrInput = new String[] {
			"dlaehdwns2020@naver.com",
				"dlaehdwnsnaver.com"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "주민등록번호";
		regex = "\\d{6}\\-[1-4]\\d{6}"; // TODO
		arrInput = new String[] {
			"000222-3032134",
				"000012-234",
				"032133-312312"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "날짜 YYYY-MM-DD";
		regex = "(19|20)\\d{2}\\.((11|12)|(0?(\\d)))\\.(30|31|((0|1|2)?\\d))"; // TODO
		arrInput = new String[] {
			"2024.04.03",
				"202405.03"

		};
		System.out.println(title);
		regExpTest(regex, arrInput);
		
		//─────────────────────────────────────────
		title = "자연수";
		regex = "^[0-9]*?"; // TODO
		arrInput = new String[] {
			"123445",
				"1234-3123",
				"-1"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "정수";
		regex = "\\d+"; // TODO
		arrInput = new String[] {
			"12344214",
				"312312312dsadsa",
				"032131230.23"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소수";
		regex = "\\b\\d+\\.\\d+\\b"; // TODO
		arrInput = new String[] {
			"abc",
				"123.45",
				"10.0",
				"def 10",
				"123.456"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
		title = "소숫점 둘째자리까지";
		regex = "\\b\\d+\\.\\d{1,2}\\b"; // TODO
		arrInput = new String[] {
			"123.45",
				"123.666",
				"12.23"
		};
		System.out.println(title);
		regExpTest(regex, arrInput);

		//─────────────────────────────────────────
//		title = "통화표시 (￦)";
		regex = "\\d{1,3}(,\\d{3})*(\\.\\d+)?";
		arrInput = new String[] {
				"5,000",
				"4,40,0",
				",5000",
				"40,000"
		};

		System.out.println(title);
		regExpTest(regex, arrInput);

		System.out.println("프로그램 종료");

	} // end main()

	// 도우미 함수
	public static void regExpTest(String regex, String[] arrInput) {
		for (String input : arrInput)
			regExpTest(regex, input);
	}

	public static void regExpTest(String regex, String input) {
		System.out.println("[정규표현식 매칭 테스트]-----------------");
		System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열: " + input);

		if(Pattern.matches(regex, input)) {
			System.out.println("   ●매칭●");
		} else {
			System.out.println("   Ⅹ매칭 없슴Ⅹ");
		}
		
		System.out.println();
	} // end regExpTest()

} // end class
