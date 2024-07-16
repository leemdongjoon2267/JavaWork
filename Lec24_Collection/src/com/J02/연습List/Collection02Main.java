package com.J02.연습List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		//TODO:
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator

		List<String> list1 = new ArrayList<>();
		list1.add("Cat");
		list1.add("Dog");
		list1.add("Tiger");
		list1.add("Pig");
		list1.add("Cow");

		list1.set(2, "개");
		System.out.println("수정 후");
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}

		list1.remove(4);
		System.out.println("삭제 후");
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}


		// for
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		System.out.println();

		// Enhanced-for
		for(String e : list1){
			System.out.println(e);
		}
		System.out.println();

		// Iterator
		Iterator<String> itr = list1.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}


		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












