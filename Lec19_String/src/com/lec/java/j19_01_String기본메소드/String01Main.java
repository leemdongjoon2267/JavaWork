package com.lec.java.j19_01_String기본메소드;

import java.util.Arrays;
import java.util.Scanner;

/* 문자열 (String) 관련 메소드들
 * 
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html
 * - 문자열 메소드는 꼭 정독해보세요.
 * - 매개변수의 의미, 동작의 의미, 리턴값의 의미 꼭 숙지해주세요
 * - 인스턴스 메소드 인지, 클래스 메소드(static) 인지 구분 
 */
public class String01Main {

	public static void main(String[] args) {
		System.out.println("String 클래스의 메소드들");
		
		String str1 = "AbCdEfg";
		String str2 = "안녕하세요~";
		
		System.out.println();
		System.out.println("length()");  // 문자의 개수
		System.out.println(str1.length());
		System.out.println(str2.length());

		System.out.println();
		System.out.println("concat()");  // 문자열 연결 (concatenation)
		System.out.println(str1.concat(str2));
		System.out.println(str2.concat(str1));
		System.out.println(str1.concat(str2).concat(str1));

		
		// ★주의★
		// 문자열(String) 은 변경불가(immutable) 이기 때문에
		// 메소드 수행했다고 하여 원본이 변경되지 않는다.
		System.out.println(str1); // 원본은 바뀌지않고 새로운 문자열 생성
		str1 = str1.concat(str2); // 변경하려면 이와같이 덮어쓰기
		System.out.println(str1);


		// ★주의★
		// empty 문자열과 null 은 다르다
		// null 인 경우 메소드 수행하면 NullPointerException 발생!
		String str3 = "";
		System.out.println(str3.length());
		str3 = null;
//		System.out.println(str3.length()); // 에러 : NullPointerException 발생(NPE)


		System.out.println();
		System.out.println("charAt(index)"); // 문자열 안의 특정위치(index)의 문자 리턴, 인덱스 범위 벗어나면 StringIndexOutOfBoundsException
											// 문자열 인덱스는 0 부터 시작!
		System.out.println(str1.charAt(0));
		System.out.println(str1.charAt(1));
//		System.out.println(str1.charAt(20)); // 에러 : StringIndexOutOfBoundsException 발생

		System.out.println();
		System.out.println("indexOf(char), indexOf(String)"); // 문자열 안에서 특정 문자(char) 혹은 문자열(String)의 위치(index), 발견 못하면 -1 리턴
		System.out.println(str1.indexOf('C')); // 배열의 2번째 index 에 있어서 2 반환
		System.out.println(str1.indexOf('c')); // 못찾으면 -1 리턴
		System.out.println(str1.indexOf('요')); // 문자여서 ' '
		System.out.println(str1.indexOf("하세")); // 문자열이여서 " "

		System.out.println();
		System.out.println("toUpperCase(), toLowerCase");  // 대문자 변환, 소문자 변환
		System.out.println(str1.toUpperCase()); // 모두 대문자
		System.out.println(str1.toLowerCase()); // 모두 소문자

		System.out.println();
		System.out.println("startsWith(), endsWith()");  // 문자열이 주어진 prefix문자열로 시작하는지 여부 true/false 리턴
		String prefix = "http://";
		String url = "www.google.com";
		System.out.println(url.startsWith(prefix)); // false
		
		System.out.println();
		System.out.println("split(regex)"); // 문자열을 주어진 문자열로 쪼개어 String[] 리턴
		String str4 = "HH:MM:SS";
		String[] arr = str4.split(":"); // : 기준으로 분리해서 String 타입의 배열로 리턴
		System.out.println(Arrays.toString(arr));

		str4 = "2024-04-02 12:20:52";
		String date = str4.split(" ")[0];
		String time = str4.split(" ")[1];
		System.out.println(Arrays.toString(date.split("-")));
		System.out.println(Arrays.toString(time.split(":")));

		str4 = "Hello My World";
		System.out.println(Arrays.toString(str4.split(" ")));
		str4 = "    Hello      My      World"; // empty String 이 공백사이마다 split으로 쪼개서 나옴
		System.out.println(Arrays.toString(str4.split(" ")));

		// 공백기준으로 쪼갤때는 정규표현식의 \s+  사용하기 : 공백, 탭, 줄바꿈
		System.out.println(Arrays.toString(str4.trim().split("\\s+")));
		// trim() : 문자열의 앞뒤 공백을 제거해줌
		
		// 단!  "|" 을 할경우는 주의,   ※ split(정규표현식) 을 사용하는 메소드임
		String str5 = "HH|MM|SS";
		// TODO
		
		// String.join() 
		// 문자열들, 문자열 배열  --> 하나의 문자열로 합하기     split() 과 반대
		System.out.println();
		System.out.println("String.join(delimeter, elements ...)");
		String[] str7 = {"Alice", "Bob", "Carol"};
		System.out.println(String.join("-", str7));
		
		
		System.out.println();
		System.out.println("substring(beginIndex, endIndex)");  // 문자열의 일부분 추출 beginIndex ~ endIndex직전 까지,  인덱스 범위 벗어마면 IndexOutOfBoundsException 
		String str8 = "Hello Java";
		System.out.println(str8.substring(2, 5)); // index 2부터 5전까지
		System.out.println(str8.substring(6)); // index 6부터 끝까지
			
		
		System.out.println();
		System.out.println("trim()");   // 좌우의 여백 제거
		String str9 = "   김동후   ";
		System.out.printf("[%s]\n", str9);
		System.out.printf("[%s]\n", str9.trim());

		// Java11 에 추가:
		// strip()   좌우 공백 제거
		// stripLeading()  좌측 공백 제거
		// stripTrailing() 우측 공백 제거
		System.out.printf("[%s]\n", str9.strip());
		System.out.printf("[%s]\n", str9.stripLeading());
		System.out.printf("[%s]\n", str9.stripTrailing());
		
		// repeat(n) 문자열 반복
		System.out.println("-".repeat(20));


		System.out.println();
		System.out.println("replace(target, replacement)");   // 문자열 치환  target → replacement  
		String str10 = "Hello Language My Language";
		System.out.println(str10.replace("My", "Our"));
		System.out.println(str10.replace("Language", "Java")); // 매칭되는 모든 것을 치환

		System.out.println();
		System.out.println("replaceAll(regex, replacement), replaceFirst(regex, replacement)"); // 정규표현식 사용버젼  , replaceAll() 매칭되는것 전부 치환, replaceFirst() 첫매칭만 치환
		System.out.println(str10.replaceAll("Language", "Java"));
		System.out.println(str10.replaceFirst("Language", "Java"));

		System.out.println();
		System.out.println("equals(), equalsIgnoreCase()");  // 문자열 비교
		String str11 = "Java";
		String str12 = "java";
		// TODO
		
		System.out.println();
		System.out.println("String.format()");
		// TODO
		
		
		// 연습 : id /pw 입력받고요
		//  로그인 성공 여부를 출력해주세요
		
		Scanner sc = new Scanner(System.in);
		
		// TODO
		
		sc.close();

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









