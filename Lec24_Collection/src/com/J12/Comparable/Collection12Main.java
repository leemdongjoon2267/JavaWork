package com.J12.Comparable;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

/* java.util.Collections 클래스
	 Collections 클래스는 여러 유용한 알고리즘을 구현한 메소드들을 제공
	 대부분 클래스메소드 (static) 형태로 제공됨
	 
	 정렬(sort)
	 섞기(shuffle)
	 탐색(search)
 */

public class Collection12Main {

	public static void main(String[] args) throws ParseException {
		System.out.println("Collections 메소드");

		List<String> list1 = Arrays.asList("장길산", "김철수", " 구자철");

		System.out.println(list1);
		
		
		System.out.println("sort()");
		// sort()
		// 기본적으로 속도가 비교적 빠르고 안전성이 보장되는 Merge Sort 사용

		Collections.sort(list1); // 오름차순 정렬
		System.out.println(list1);
		
		// String 타입이면 알파벳 순으로 정렬된다.
		// Date 타입이면 날짜순으로 정렬된다
		// ★ String 과 Date 는 기본적으로 Comparable<T> 인터페이스가 구현되었기 때문.
		// ※ String 온라인 도움말 확인해보자
	
		System.out.println();
		List<LocalDate> list2 = new LinkedList<>();
		list2.add(LocalDate.parse("2018-08-16")); // 문자열로부터 java.time 패키지로 전송
		list2.add(LocalDate.parse("2017-05-21"));
		list2.add(LocalDate.parse("2022-03-03"));

		System.out.println(list2);
		Collections.sort(list2); // 오름차순 정렬
		System.out.println(list2);

		List<Student> list3 = new LinkedList<Student>();
		list3.add(new Student("Susie", 50));
		list3.add(new Student("James", 80));
		list3.add(new Student("Kevin", 30));

		System.out.println(list3);

		System.out.println("Comparable 구현, sort() 적용");
		Collections.sort(list3); // 아래 클래스에서 구현 안받으면 에러남
		// Student 에 Cpmparable 이 구현 안되어 있으면 에러
		System.out.println(list3); // 점수의 오름차순
		
		// 역순 정렬
		System.out.println("reverseOrder() 적용");

		Collections.sort(list3, Collections.reverseOrder());
		System.out.println(list3);
		
		// 뒤집기
		System.out.println("reverse() 적용");
		Collections.reverse(list3); // 정렬이 아니라 그냥 뒤집는거 Comparable 이랑 전혀 상관 없음
		System.out.println(list3);


		// Comparable [kɑ́ːmpərəbl] 발음 : '캄퍼러블
		// Comparator [kəmpǽrətər]발음 : 컴'패러터

		// Comparator<> 적용
		// Collections.sort 메소드는 두 번째 인자로 Comparator 인터페이스를 받을 수 있도록 해놓았습니다.
		// Comparator 인터페이스의 compare 메소드를 오버라이드 하면 됩니다.
		System.out.println("Comparator<> 적용");
		Collections.sort(list3, new Asc()); // new Asc() : Comparator<>
		// new Asc 빼면 오름차순으로 감
		System.out.println(list3);

		Collections.sort(list3 , new Desc());
		System.out.println(list3);
		
		// Collections 에서 많이 쓰이는 인터페이스임
		// Comparable<> 은 클래스 자체에 구현하는 인터페이스  compareTo(자기사진 vs 매개변수)
		// Comparator<> 는 두개의 객체 비교하는 기능제공 인터페이스  compare(매개변수1 vs 매개변수2)
		//      구현된 객체가 매개변수 등에 넘겨지는 형태로 많이 쓰임

		// 객체의 '동일여부' ==> hashCode(), equals() 구현
		// 객체의 '대소비교' ==> Comparable<> 구현, 혹은 Comparator<> 사용
		
		// Shuffling 하기 (섞기)
		System.out.println();
		System.out.println("shuffle()");
		Collections.shuffle(list1); // 랜덤으로 섞음
		System.out.println(list1);
		Collections.shuffle(list1);
		System.out.println(list1);

		// 배열에서 랜덤으로 3명만 뽑기
		String [] arr = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg"};
		List<String> arrList = Arrays.asList(arr); // 배열을 리스트로 받음, 벼열에서 리스트를 만들음
		Collections.shuffle(arrList);
		System.out.println(arrList.subList(0, 3)); // index 0 부터 3 전까지 List<> 리턴

		// min(), max()
		// Comparable 메소드 영향 받음
		System.out.println();
		System.out.println("min(), max()");
		System.out.println(Collections.min(list1));
		System.out.println(Collections.max(list1));
		System.out.println(Collections.min(list3));
		System.out.println(Collections.max(list3));

		// copy(dest, src)
		System.out.println();
		// TODO
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

// 우선은 Comparable 구현 없이 해보자
class Student implements Comparable<Student>{
	String name;
	double point;
	
	public Student(String name, double point) {
		super();
		this.name = name;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return this.name + ":" + this.point + "점";
	}


	//comparaTo() 메소드는 매개변수 객체를 자신객체(this)와 비교하여
	// 정렬순위가 낮으면 음수, 같으면 0, 높으면 양수를 반환한다.
	@Override
	public int compareTo(Student o) {

		// compareTo 로 구현된 객체는 compareTo 사용 가능함

		// 점수(point) 오름차순
		if(o.point > this.point) return -1; // other 의 point 가 내꺼보다 높으면 -1 리턴
		if(this.point > o.point) return 1; // 내 point 가 더 높으면 1 리턴
		return 0;

		// 점수(point) 내림차순
//		if(o.point < this.point) return -1;
//		if(this.point < o.point) return 1;
//		return 0;

		// 이름(name) 오름차순
//		return this.name.compareTo(o.name); // J < K < S

		// 이름(name) 내림차순
//		return o.name.compareTo(this.name); // J > K > S

//		return o.name.toUpperCase().compareTo(this.name.toUpperCase()); // 대소문자 구분없이

	}

	// TODO

} // end class


class Asc implements Comparator<Student>{

	// 두개의 객체를 비교
	// o1 이 o2 보다 우선순위 낮으면 음수 리턴
	// o1 이 o2 보다 우선순위 높으면 양수 리턴
	// o1 과 o2 가 같으면 0 리턴

	@Override
	public int compare(Student o1, Student o2) {
		// 점수 내림차순
//		if(o1.point < o2.point) return 1;
//		if(o1.point > o2.point) return -1;
//		return 0;

		// 이름(name) 오름차순
		return o1.name.compareTo(o2.name);
	}

	// TODO
	
} // end Asc


class Desc implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {

		// 이름 내림차순
		return -o1.name.compareTo(o2.name); // 또는 o1, o2 순서 바꿔도됨
	}

	// TODO
	
} // end Desc

