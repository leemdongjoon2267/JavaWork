package com.lec.java.j24_03_Lambda연습;

import java.util.*;

/*
	 세가지 방법으로 자유자재로 구현할수 있어야 합니다.
	 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
	 방법 2) 익명클래스
	 방법 3) 람다 표현식 lambda expression
*/
public class Lambda03Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");

		//-----------------------------------------------
// Comparator<T>
		System.out.println("\nComparator<T>");
		List<Student> list3 = Arrays.asList(
				new Student("Susie", 50),
				new Student("James", 80),
				new Student("Kevin", 30)
		);
		System.out.println(list3);


// 점수 오름차순
// 익명클래스 사용
		Collections.sort(list3, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return (int)(o1.point - o2.point);
			}
		});
		System.out.println(list3);

		// 점수 내림차순
		// lambda 사용
		Collections.sort(list3, (o1, o2) -> (int)(o2.point - o1.point));
		System.out.println(list3);


		// 이름 오름차순
		Collections.sort(list3, (o1, o2) ->  o1.name.compareTo(o2.name));
		System.out.println(list3);

		// 이름 내림차순
		Collections.sort(list3, (o1, o2) ->  o2.name.compareTo(o1.name));
		System.out.println(list3);



		//----------------------------------------
		System.out.println("-".repeat(20));
		{
			Map<String, Integer> hmap = new HashMap<>();
			//   단어,  횟수
			hmap.put("BBB", 200);
			hmap.put("AAA", 400);
			hmap.put("CCC", 100);
			System.out.println(hmap);


			// 실습 : lambda 활용
			// 1. 횟수 오름차순 출력
			List<Map.Entry<String, Integer>> list = new ArrayList<>(hmap.entrySet());
			// Map 은 순서가 없어서 List 로 받음

			// 횟수 오름차순
			Collections.sort(list, (o1, o2) -> o1.getValue() - o2.getValue());
			// Value 를 리턴
			System.out.println(list);

			// 위에랑 같은 결과
			Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));
			System.out.println(list);

			// 횟수 내림차순
			Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
			// Value 를 리턴
			System.out.println(list);

		}



		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class


