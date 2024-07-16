package com.J05.HashSet;

/* Set, HashSet<E>

	Collection<E>
	 |__ Set<E>
	      |__ HashSet<E>, TreeSet<E>
	
	 Set:
	 1. 자료의 중복 저장이 허용되지 않는다. (hashCode() 값의 중복여부!)
	 2. 저장 순서가 유지되지 않는다.(인덱스 없다.)
	 (예) {1, 2, 3} = {1, 1, 2, 2, 3} : 중복 저장이 안되기 때문에 같은 Set
	 (예) {1, 2, 3} = {1, 3, 2}: 저장 순서가 중요하지 않기 때문에 같은 Set
	
	 HashSet: 매우 빠른 검색 속도를 제공

	 	(※ HashXXX ← '검색속도 향상'을 쓰는 자료구조 입니다)
*/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collection05Main {

	public static void main(String[] args) {
		System.out.println("HashSet 클래스");
		
		// Integer 타입을 저장할 수 있는 HashSet 인스턴스 생성
		Set<Integer> hset = new HashSet<>(); // Hash 생략 가능
		
		// 데이터 저장: add()
		hset.add(100);
		hset.add(200);
		hset.add(300);
		hset.add(100);
		hset.add(400);
		hset.add(500);
		hset.add(1);
		hset.add(2);
		// 데이터 중복을 허용하지 않으므로 7개가 들어가 있음

		// HashSet의 크기: size()
		System.out.println("size(): " +hset.size());
		
		// Set은 중복 저장을 허용하지 않는다.
		
		// 데이터 검색:
		// Set은 인덱스가 없기 때문에 get() 메소드를 제공하지 않습니다.
		// 데이터 검색을 위해서는 Iterator를 사용해야 함
		System.out.println();
		Iterator<Integer> itr = hset.iterator(); // Set 요소 뽐아냄
		while(itr.hasNext()){
			System.out.println(itr.next()); // 출력결과 보면 저장순서와는 관계없음
		}
		
		
		
		
		// 데이터 삭제
		// remove(element): Set에 있는 element를 찾아서 삭제
		//   element 있다면 삭제 후 true를 리턴
		//   element 없다면 false 리턴
		System.out.println("삭제결과: " + hset.remove(2)); // index 2 를 제거하는게 아니라 element 2 를 제거함(2 라는 데이터 제거)
		System.out.println("삭제결과: " + hset.remove(2)); // false 리턴

		System.out.println();
		System.out.println("삭제 후:");
		itr = hset.iterator(); // 한번 사용한 iterator 는 다시 사용 불가하므로 새로 생성해야함
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		// Set 자료형 데이터 변경을 할 수 있는 set() 메소드를 제공하지 않습니다.
		// 삭제(remove) 후 추가(add)하면 변경하는 효과
		// TODO : 500 -> 555 로 변경하고 싶다면?
		hset.remove(500);
		hset.add(555);
		System.out.println("변경 후: ");

		// enhanced-for 사용
		System.out.println();
		System.out.println("Enhanced for 사용 출력");
		for(Integer x : hset){
			System.out.println(x);
		}

		System.out.println("contains()");
		System.out.println(hset.contains(300));
		System.out.println(hset.contains(900));

		// forEach() 메소드 사용
		System.out.println();
		System.out.println("forEach() 사용 출력");
		// TODO

		// toString() 제공됨
		System.out.println();
		System.out.println(hset);

		System.out.println("\n다양한 Set initializer");
		// 참고: https://www.baeldung.com/java-initialize-hashset
		//      https://stackoverflow.com/questions/2041778/how-to-initialize-hashset-values-by-construction
		{
			Set<String> set = new HashSet<>();

			// List, 배열로부터 생성
			set = new HashSet<>(Arrays.asList("a", "a", "b"));
			System.out.println(set);
			// 중복 제거하고 만듬

			// Collections utility 클래스 하용
			Collections.addAll(set, "aa", "aa", "bb");
			System.out.println(set);

			// Stream 사용 (Java8 이상)
//			set = TODO
//			System.out.println(set);

			// Factory method (Java9 이상)
			set = Set.of("a", "b");
//			set = Set.of("a", "a", "b"); // 중복된 값 허용안함
			System.out.println(set);

			// Double-brace initialization
			// 비추
//			set = TODO
//			System.out.println(set);

			// 그밖에도 guava 라는 3rd party 라이브러리도 활용할수 있다
			// https://guava.dev/releases/22.0/api/docs/com/google/common/collect/Sets.html#newHashSet--
			// Sets.newHashSet("a", "b", "c")
		}

		// HashSet에서 값을 찾을 때에는 이미 존재하는 요소인지 파악하기 위해서 아래와 같은 과정을 거치게 된다.
		// 검색할 값의 hashCode() 메소드를 호출해 반환된 해시값으로 검색 범위를 결정한다.
		// 해당 범위의 요소를 equals() 메소드로 비교한다. (Array Index에 있는 Linked List들과 값을 비교)
		System.out.println();
		{
			Person p1 = new Person(1,20,"Mike");
			Person p2 = new Person(1,20,"Mike");
			Person p3 = new Person(2,10,"John");

			HashSet<Person> personSet = new HashSet<>();
			personSet.add(p1);
			personSet.add(p2);
			personSet.add(p3);

			System.out.println("p1 hashCode(): " + p1.hashCode());
			System.out.println("p2 hashCode(): " + p2.hashCode());

			System.out.println("p1.equals(p2): " + p1.equals(p2));
			System.out.println("p2.equals(p1): " + p2.equals(p1));

			System.out.println(personSet.size());

//			TreeSet<Person> tset2 = new TreeSet<>();
//			tset2.add(p1);
//			tset2.add(p2);
//			tset2.add(p3);

		}
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


class Person{
	int id;
	int age;
	String name;

	public Person(int id, int age, String name) { // 생성자
		this.id = id;
		this.age = age;
		this.name = name;
	}

	// 해쉬 코드 오버라이딩
	@Override
	public int hashCode() {
		return id * age;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Person)obj).id;
	}

	// 해쉬 코드값이 같고 equals 값이 같아야 같은 거다
}









