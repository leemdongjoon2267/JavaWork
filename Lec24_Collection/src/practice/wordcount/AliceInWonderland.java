

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */
// TODO : 필요한 객체들 작성
// hint> 빈도수 담을 객체, Comparator<> ..
package practice.wordcount;

import java.util.*;

public class AliceInWonderland {

	public static void main(String[] args) {		
		System.out.println("실습: 단어 발생 빈도");
		Map<String, Integer> hmap = new HashMap<>();
		// key - String 타입 value - Integer 타입인 HashMap 인스턴스 생성

//		String [] words = C.ALICE30.trim().toLowerCase().split("\\s+");
//		String[] words = C.ALICE30.trim().toLowerCase().replaceAll("[.,\"'`!?;:\\-\\(\\)]", "").split("\\s+");
		String [] words = C.ALICE30.trim().toLowerCase().split("[^a-z]+");

		List<Word> AliceWord = new ArrayList<Word>();

		// 발생빈도 작성
		for (int i = 0; i < words.length; i++) {
			Integer count = hmap.get(words[i]); // // words[i]가 key 값으로 가지고 있는 여부를 알려줌
			if(words[i].length() > 1){ // 2글자 이상
				if(count == null){ // 기존 Map 에 해당 key 가 없었다면(즉, 첫 등장이라면!)

					hmap.put(words[i], 1); // 첫 등장

				}else{ // 기존 Map 에 해당 key 가 존재했다면(즉, 이전에 최소 1번이상 등장했다면!)

					hmap.put(words[i], count + 1); // 기존에 등장횟수에 +1 증가(수정)
				}
			}
		}

		for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
			AliceWord.add(new Word(entry.getKey(), entry.getValue()));
		}

		Desc descComparator = new Desc();
		Collections.sort(AliceWord, descComparator);

		// 결과 출력 (순번 없는거)
//		for (Word word : AliceWord) {
//			System.out.println(word.word + " : " + word.count + "개");
//		}

		// 결과 출력
		int cnt = 1;
		for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
			System.out.printf("%3d %-14s : %2d개\n", cnt++, entry.getKey(), entry.getValue());
		}


		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

 class Word {
	String word;
	int count;

	public Word(String word, int count) {
		this.word = word;
		this.count = count;
	}
}

// 빈도수를 기준으로 내림차순 정렬
class Desc implements Comparator<Word> {
	@Override
	public int compare(Word o1, Word o2) {
		return Integer.compare(o2.count, o1.count);
	}
} // end class




