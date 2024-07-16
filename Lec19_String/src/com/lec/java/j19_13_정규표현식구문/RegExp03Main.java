package com.lec.java.j19_13_정규표현식구문;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 정규표현식 에 사용하는 각종 표현식들
 * 	정규표현식		설명
 * 	^			문자열 시작
 * 	$			문자열 종료
 * 	.			임의의 문자 [단 ‘'는 넣을 수 없습니다.]
 * 	*			앞 문자가 0개 이상의 개수가 존재할 수 있습니다.
 * 	+			앞 문자가 1개 이상의 개수가 존재할 수 있습니다.
 * 	?			앞 문자가 없거나 하나 있을 수 있습니다.
 * []			문자의 집합이나 범위를 표현합니다. -기호를 통해 범위를 나타낼 수 있습니다. ^가 존재하면 not을 나타냅니다.
 * {}			횟수 또는 범위를 나타냅니다.
 * ()			괄호안의 문자를 하나의 문자로 인식합니다. (그룹)
 * |			패턴을 OR 연산을 수행할 때 사용합니다.
 * \s			공백 문자
 * \S			공백 문자가 아닌 나머지 문자
 * \w			알파벳이나 숫자
 * \W			알파벳이나 숫자를 제외한 문자
 * \d			[0-9] 숫자
 * \D			숫자를 제외한 모든 문자
 * (?i)			대소문자를 구분하지 않습니다.
 * 
 * 
 * 자바 정규표현식에 사용되는 escaped character 들
 *    \.[]{}()<>*+-=!?^$|
 */
public class RegExp03Main {

	public static void main(String[] args) {
		System.out.println("정규표현식\n");

		String regex, intput, title;
		String [] arrInput;
		
		//─────────────────────────────────────────
		title = "^ : 바로 문자뒤의 문자열로 시작됨";
		regex = "^The"; // The 로 시작하는 문자열 패턴
		arrInput = new String[] {
				"The Things",
				"On The Things",
				" The The The",
				"There you go",
		};
		
		//─────────────────────────────────────────
		title = "$ : 문자열의 마지막이 이 문자열로 마무리 됨";
		regex = "Man$"; // Man 으로 끝나는 문자열
		arrInput = new String[] {
				"SuperMan", // ok
				"AquaMan", // ok
				"WonderWoman", // x
				"WonderWoMan", // ok
				"PostMan ", // x

		};
			
		//─────────────────────────────────────────
		title = "^표현식$ : 정확하게 전체패턴매칭되는 문자열";
		regex = "^SuperMan$"; // Super 로 시작하고  Man 으로 끝나는 문자열
		arrInput = new String[] {
				"SuperMan",
				"Super Man",
				" SuperMan",
				"SuperMan ",
		};
		
		//─────────────────────────────────────────
		title = " . : 어떤 문자든지 임의의 '한문자'를 말한다.꼭 하나의 문자와 매칭";
		regex = "x.y";
		arrInput = new String[] {
				"xyz", // x
				"xxzdfdk", // x
				"aa10x9zbxbz", // x
				"xz", // x
				"90x zxx_zdf", // x
				"xbz", // x
				"xyyz", // xyy

		};
		
		//─────────────────────────────────────────
		title = " * : 바로 앞의 문자가 없거나 한개 이상의 경우를 매칭";
		regex = "ab*"; // a는 반드시 있어야하지만 b는 없어도되고 한개 이상일때도 매칭
		arrInput = new String[] {
				"a",  // 1	"a"
				"abc", // 2	"ab"
				"ab", // 3	"ab"
				"abbbaaaabababbab", // 4 (8개 매칭)
				"bbba",  // 5 "a"
				"cdef"  // 6 x

		};
		
		//─────────────────────────────────────────
		title = " + : 바로 앞의 문자를 나타내면 꼭 한개 혹은 그 이상을 매칭";
		regex = "ab+"; // a와 b 무조건 한개 이상 나와야 매칭
		arrInput = new String[] {
				"a",  // 1	x
				"abc", // 2	"ab"
				"ab", // 3	"ab"
				"abbbaaaabababbab", // 4 (5개 매칭)
				"bbba",  // 5 x
				"cdef"  // 6 x
		};
		
		//─────────────────────────────────────────
		title = " ? : 바로 앞의 문자가 한개 있거나 없는것을 매칭";
		regex = "ab?"; // a는 반드시 있어야되고 b는 없어도 되고 있으면 한개까지 매칭
		arrInput = new String[] {
				"a",  // 1 "a"
				"abc",  // 2 "ab"
				"kkabcc",  // 3 "ab"
				"abbbaaaabababbab", // 4 (8개 매칭)
				"bbba"  // 5 "a"

		};

		//─────────────────────────────────────────
		title = " [] : 안에 존재하는 문자들중 한 문자만을 매칭";
		regex = "[abc]"; // a 또는 b 또는 c  중에 한 문자 매칭
		arrInput = new String[] {
				"able", // 1 "a", "b"
				"bible",  // 2 "b", "b"
				"cable",  // 3 "c", "a", "b"
				"xenosys", // 4 x

		};

		regex = "[abc]+"; // a 또는 b또는 c가 한개 이상일때만 매칭
		regex= "[a-z}+"; // a 부터 z 까지

		arrInput = new String[] {
				"abc100", // abc
				"abcDefGHIUJ-KLM123opQrstuz" // 4개 매칭
		};

		regex = "[a-zA-Z]+";
		regex = "[^a-zA-Z]+"; // 여기 안에서 ^ 은 NOT
		regex = "[a-zA-Z0-9]+";
		regex = "[a-zA-Z0-9-]+"; // 이러면 -도 인식해서 매칭함
		regex = "[0-9]+";

		//─────────────────────────────────────────
		title = " {} : 앞에 있는 문자나 문자열의 등장개수를 정함";
		regex = "ab{2}"; // a는 한글자 b는 두글자 매칭
		arrInput = new String[] {
				"abb", // "abb"
				"abbb", // "abb"
				"abbbabbbbbbbbabaabab", // (2개 매칭) "abb", "abb"

		};

		regex = "ab{2,}"; // b의 등장 개수가 2개 이상
		regex = "ab{3,5}"; // b의 등장 개수가 3개부터 5개까지
		
		//─────────────────────────────────────────
		title = " () : ()안에 있는 글자들을 그룹화 ";
		regex = "a(bc)*"; // a 다음에 (bc) 가 없거나 한개 이상 반복
		arrInput = new String[] {
				"abc", // "abc"
				"abcbcbbac", // "abc", "bc", "ac"
				"abcabcabc", // "abc", "abc", "abc"

		};
		
		//─────────────────────────────────────────
		title = " | : OR 연산자  역할";
		regex = "a|b"; // a 또는 b
		arrInput = new String[] {
				"a", // "a"
				"b", // "b"
				"ab", // "a", "b"
				"xyz"
		};

		regex = "(a|b)+"; // a 나 b 가 한개 이상 매칭
		
		//─────────────────────────────────────────
		title = "(?i)  : 대소문자 구분안하고 매칭 ";  // 타 언어 정규표현식과 다름
		regex = "(?i)abc"; // TODO
		arrInput = new String[] {
				"abc",
				"Abc",
				"ABC",
		};
		
		//─────────────────────────────────────────
		title = "\\s : 공백,  \\S : 공백아닌 문자";  // 공백 : 띄어쓰기, \n, \t, \r ...
		regex = "\\s+"; // 공백 한개 이상
		arrInput = new String[] {
				"Hello My World", // 2
				"He \tllo My World", // 3
				"\n\t Hello My World\n\n", // 4
		};

		regex = "\\S+"; // 공백이 아닌 문자
		
		//─────────────────────────────────────────
		title = "\\w : 알파벳이나 숫자, \\W 알파벳이나 숫자를 제외한 문자";
		regex = "\\w+"; // TODO
		arrInput = new String[] {
				"This is 2024-04-03" // 5

		};

		regex = "\\W+"; // 4
		

		//─────────────────────────────────────────
		title = "\\d : [0-9] 숫자, \\D 숫자를 제외한 모든 문자";
		regex = "\\d+"; // 숫자 한개 이상
		arrInput = new String[] {
				"This is 2024-04-03" // 3
		};

		regex = "\\D+"; // 3
		
		//─────────────────────────────────────────
		title = "escaped character 매칭 시키기";
//		regex = ".+"; // 이렇게 하면 전체 문자가 매칭됨
		regex = "[.]+"; // ... 나옴
		regex = "\\.+"; // ... 나옴
		arrInput = new String[] {
				"My name is ..."
		};
		
		//*****************************************
		// 패턴매칭 수행
		System.out.println(title);
		regExpTest(regex, arrInput);

		System.out.println("프로그램 종료");
	} // end main()
	
	// 도우미 함수
	public static void regExpTest(String regex, String [] arrInput) {
		for(String input : arrInput) regExpTest(regex, input);
	}
	
	public static void regExpTest(String regex, String input) {
		System.out.println("[정규표현식 매칭 테스트]-----------------");
		System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열: " + input);
		
		Matcher matcher = Pattern.compile(regex).matcher(input);
		int groupCount = matcher.groupCount();  // 그룹 개수
		
		int matchCount = 0;		
		while(matcher.find()) {
			matchCount++;
			System.out.println("    매치" + matchCount + ": " + matcher.group() + " {" + matcher.start() + "~" + matcher.end() + "}");
			
			// 그룹이 있으면 group별 출력
			if(groupCount > 0) {
				for(int i = 0; i <= groupCount; i++) {	 // i 범위 주목!	
					System.out.printf("\t group(%d): %s {%d~%d}\n",
							i, matcher.group(i), matcher.start(i), matcher.end(i));
				}
			}
			
		} // end while
		if(matchCount == 0) System.out.println("   Ⅹ매치 없슴Ⅹ");
		System.out.println();
	} // end regExpTest()

} // end class
