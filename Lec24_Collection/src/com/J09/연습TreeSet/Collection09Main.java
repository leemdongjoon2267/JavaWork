package com.J09.연습TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class Collection09Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 연습");
		
		// String 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		// 5개 이상의 데이터를 저장해보고
		// 오름차순, 내림차순으로 출력해보기
		TreeSet<String> tset = new TreeSet<>();
		tset.add("dog2");
		tset.add("cat3");
		tset.add("Hello");
		tset.add("java");
		tset.add("world");
		tset.add("world");
		tset.add("AaAa");
		tset.add("aAaA");
		tset.add("bbBd");
		tset.add("bBbB");
		tset.add("BbBc");

		System.out.println("오름차순");
		Iterator<String> itr = tset.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}

		System.out.println("-------------------------");

		System.out.println("내림차순");
		itr = tset.descendingIterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}

		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

















