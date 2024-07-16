package com.J02.stream연산;

import common.Customer;

import java.util.*;
import java.util.stream.*;

/**
 *   스트림 연산
 *  스트림 연산은 기존자료를 변경하지 않음 (즉 배열에서 생성한 스트림이 원본 배열을 직접 건드리진 않음)
 *  스트림 연산은 '중간연산'과 '최종연산'으로 구분됨
 *
 *  	'중간연산'
 *  		어떤 조건으로 자료를 filtering 한다든가, 어떤 조건에 맞는 자료를 꺼내온다든다
 *  		중간연산은 체이닝 된다.
 *
 *  		map(), filter(), sorted(), distinct()
 *  		limit(), skip(), peek(), boxed()
 *  		mapToInt(), mapToDouble(), mapToLong()
 *  		...
 *
 *          중간연산은 데이터를 다시 Stream 타입으로 리턴하기 때문에 이후 체이닝 가능.
 *
 *
 *  	'최종연산 (터미널 연산)'
 *  		그 결과를 출력한다든가, 합 혹은 평균을 구하는 등의 연산 -> '결과'가 나온다
 *  		최종연산은 자료를 '소모' 하면서 연산을 수행
 *  		그래서, 맨 마지막에 등장. 최종연산후에 스트림은 더이상 다른연산 적용 불가.
 *  		최종연산이 적용(수행)되어야 모든 그 앞의 중간연산이 적용되는 '지연연산'이 발생
 *
 *          forEach()
 *  		min(), max(), count(), sum(), average()
 *  		reduce(a, b)
 *  		anyMatch(), allMatch(), noneMatch(),
 *  		findFirst(), findAny(),
 *  	    collecting()
 */

public class Stream02Main {
	public static void main(String[] args) {
		System.out.println("Stream 연산");

		List<String> stringList = Arrays.asList("John", "Susan", "Tom", "Michael");
		Customer[] arrCustomer = {
				new Customer("John", 32),
				new Customer("Susan", 22),
				new Customer("Tom", 55),
				new Customer("john", 43),
		};
		List<Customer> customerList = Arrays.asList(arrCustomer);

		//----------------------------------------------------------------------
		// forEach(Consumer<T>)    [최종연산]
		// 리턴값: void
		// 주어진 Stream 을 순환하며 연산 수행
		System.out.println("-".repeat(30) +"\n▶ forEach(Consumer<T>)");
		{
			// customerList 의 내용 출력하기
			// 1. for 사용
			for (int i = 0; i < customerList.size(); i++) {
				System.out.println(customerList.get(i));
			}

			System.out.println("-".repeat(20));

			// 2. stream 사용
			Stream<Customer> stream1 = customerList.stream();
			stream1.forEach(s -> System.out.println(s));
			// ★한번 최종연산한 스트림은 다시 사용 불가 --> IllegalStateException
//			stream1.forEach(s -> System.out.println(s));

			// 다시 Stream 생성해서 사용가능
			stream1 = customerList.stream();
			stream1.forEach(s -> System.out.println(s)); // 관계 없음

			// 문자열의 문자 개수 출력하기
			System.out.println();
			stringList.stream().forEach(s -> System.out.print(s.length() + " "));
			System.out.println();
		}


		//----------------------------------------------------------------------
		// filter(Predicate<T>)   [중간연산]
		//   주어진 Stream 에서 Predicate 이 true 로 판정(리턴)하는 것들의 Stream을 생성하여 리턴
		//   입력 ->  출력
		//    n개 ->  <=n개

		 System.out.println("-".repeat(30) +"\n▶ filter(Predicate<T>)");
		{
			System.out.println(stringList);

			// 문자열의 길이가 5 이상인 요소만 출력하기

			// 1. for 사용
			for(var str : stringList){
				if(str.length() >= 5){
					System.out.println(str);
				}
			}

			// 2. stream 사용
			stringList.stream()
					.filter(s -> s.length() >= 5) // 중간연산, 리턴 타입 : Stream<String>
					.forEach(System.out::println) // 최종연산
			;

			// 도전] 나이가 40살 이하인 사람만 출력, Stream, filter() 사용

			System.out.println("-".repeat(20));
			customerList.stream().filter(c -> c.getAge() <= 40).forEach(System.out::println);
		}


		//---------------------------------------------------------------------
		// Map(Function<T, U>)  [중간연산]
		// Stream 의 요소 '각각'에 '연산을 적용하여 변환'한 Stream 리턴
		// 입력  =>  출력
		//  n개  =>  n개

		 System.out.println("-".repeat(30) +"\n▶ map(Function<T, U>)");
		{
			// Customer 리스트에서 고객 이름만 출력하기

			// 1. for 사용
			for(var c : arrCustomer){
				String name = c.getName();
				System.out.println(name);
			}

			System.out.println();
			// 2. Stream 사용
			Arrays.stream(arrCustomer) // Stream<Customer> 4 개
//					.map(Customer::getName()) // 도 가능
					.map(c -> c.getName()) // 중간 연산  Stream<String> 4개
					.forEach(System.out::println);

			System.out.println("-".repeat(20));

			// 도전] arrCustomer 에서 고객이름의 문자열 길이만 출력
			Arrays.stream(arrCustomer) // Stream<Customer>
					.map(c -> c.getName().length()) // Stream<Integer>
					.forEach(System.out::println);

		}


		//-------------------------------------------------------
		// sorted(), sorted(Comparator<T>)   [중간연산]
		//    Stream 을 정렬한 Stream<T> 리턴
		//
		// sorted() : Comparable 을 구현한 객체들의 대소비교
		// sorted(Comparator<T>):   매개변수 Comparator<>  <- 대소 비교

		 System.out.println("-".repeat(30) +"\n▶ sorted(), sorted(Comparator<T>)");
		{
			stringList.stream().forEach(System.out::println);

			System.out.println();
			// 사전순 정렬. String 은 Comparable<> 이 구현된 객체 -> sorted() 바로 사용가능
			stringList.stream()
					.sorted() // Stream<String> 정렬된 결과
					.forEach(System.out::println);

			// Comparable<> 이 구현되지 않은 객체는 sorted() 불가
//			customerList.stream()
//					.sorted()
//					.forEach(System.out::println);

			// sorted<Comparator> 사용
			// 글자 개수 오름차순으로 정렬
			System.out.println();
			stringList.stream()
					.sorted((o1, o2) -> o1.length() - o2.length())
					.forEach(System.out::println);

			// 글자 개수 내림차순으로 정렬
			System.out.println();
			stringList.stream()
					.sorted((o1, o2) -> o2.length() - o1.length())
					.forEach(System.out::println);

			System.out.println("-".repeat(20));

			// Customer 이름 오름차순 정렬
			customerList.stream()
					.sorted((c1, c2) -> c1.getName().compareTo(c2.getName())) // Stream<Customer>
					.forEach(System.out::println);

			System.out.println();
			// 도전] Customer 나이 내림차순 정렬
			customerList.stream()
					.sorted((c1, c2) -> (c2.getAge() - c1.getAge()))
					.forEach(System.out::println);

			System.out.println();
			// Comparator 에서 제공하는 comparing(Function<T, U>) 사용
			customerList.stream()
					.sorted((Comparator.comparing(Customer::getAge)))
					.forEach(System.out::println);

			System.out.println();
			// 역순
			customerList.stream()
					.sorted((Comparator.comparing(Customer::getAge).reversed()))
					.forEach(System.out::println);
		}

		//-------------------------------------------------------------
		// distinct()    [중간연산]
		//  Stream 에서 중복된 요소 제거한 Stream 리턴
		// primitive type 의 경우  == 으로 '같은지 여부' 판단
		// object type 의 경우 .equals() 로 '같은지 여부' 판단

		 System.out.println("-".repeat(30) +"\n▶ distinct()");
		int[] intArr = {9, 1, 1, 0, 2, 2, 2, 5, 9, 2, 0};
		{
			System.out.println(Arrays.toString(intArr));

			Arrays.stream(intArr) // IntStream
					.distinct()	  // IntStream (중복된 값은 제거된 Stream)
					.forEach(n -> System.out.print(n + ", "));
			System.out.println();
		}


		//-------------------------------------------------------------
		// limit(maxSize)    [중간연산]
		//   Stream 의 가장 앞 요소부터 지정한 maxSize만큼을 Stream 으로 리턴

		 System.out.println("-".repeat(30) +"\n▶ limit(maxSize)");
		{
			Arrays.stream(intArr)
					.limit(5)
					.forEach(s -> System.out.print(s + ", "));
			System.out.println();

			Arrays.stream(intArr)
					.limit(4)
					.forEach(s -> System.out.print(s + ", "));
			System.out.println();

			Arrays.stream(intArr)
					.limit(3)
					.forEach(s -> System.out.print(s + ", "));
			System.out.println();
		}

		//-------------------------------------------------------------
		// skip(n)  [중간연산]
		//   Stream 의 앞요소부터 지정한 개수 n만큼을 제외한 Stream 리턴

		 System.out.println("-".repeat(30) +"\n▶ skip(n)");
		{
			System.out.println(Arrays.toString(intArr));

			Arrays.stream(intArr)
					.skip(5)
					.forEach(s -> System.out.print(s + ", "));
			System.out.println();

			Arrays.stream(intArr)
					.skip(4)
					.forEach(s -> System.out.print(s + ", "));
			System.out.println();

			Arrays.stream(intArr)
					.skip(3)
					.forEach(s -> System.out.print(s + ", "));
			System.out.println();

			// 도전] 0, 2, 2, 2, 5, 9 <- 출력
			// hint : skip 과 limit 사용

			Arrays.stream(intArr)
					.skip(3)
					.limit(6)
					.forEach(s -> System.out.print(s + ", "));
			System.out.println();

		}

		//-------------------------------------------------------------
		// peek(Consumer<T>)   [중간연산]
		//    현재 진행중인 Stream 에 영향을 주지 않으면서 현재까지 연산된 요소들을 출력하는등의 동작 수행

		 System.out.println("-".repeat(30) +"\n▶ Consumer<T>");
		{
			List<String> nameList = new ArrayList<>();

			customerList.stream()
					.limit(2)
					.map(Customer :: getName)
					.peek(name -> nameList.add(name)) // map 의 결과를 뽑아낼때, Stream<String>
					.filter(name -> name.startsWith("J")) // "J" 로 시작하는 사람
					.forEach(System.out::println);

			 System.out.println("nameList : " + nameList);
		}

		//-------------------------------------------------------------
		// boxed()는
		// primitive 타입 스트림을 => 레퍼런스 타입 스트림으로 boxing 해준다. (boxed 스트림)

		 System.out.println("-".repeat(30) +"\n▶ boxed()");
		{
			IntStream intStream = Arrays.stream(intArr);
			Stream<Integer> boxedStream = intStream.boxed();
		}

		//-------------------------------------------------------------
		// mapToInt(), mapToDouble(), mapToLong()
		// boxed 타입 스트림 -> primitive 타입 스트림을 변환
		 System.out.println("-".repeat(30) +"\n▶ mapToInt(), mapToDouble(), mapToLong()");
		{
			Stream<Double> boxedStream;

			boxedStream = Stream.of(10., 20., 30.);
			IntStream intStream = boxedStream.mapToInt(x -> x.intValue()); // x 는 Integer 객체

			boxedStream = Stream.of(10., 20., 30.);
			DoubleStream  doubleStream = boxedStream.mapToDouble(x -> x.doubleValue());

			boxedStream = Stream.of(10., 20., 30.);
			LongStream longStream = boxedStream.mapToLong(x -> x.longValue());
		}


		/*************************************************************/
		System.out.println("■".repeat(30));
		System.out.println("[최종연산(터미널 연산)]");

		//---------------------------------------------------------------
		// sum(), count(), average()    [최종연산]
		//
		//  sum()
		//    primitive stream 에서만 사용 가능.
		//    리턴값: 해당 타입
		//  count()
		//    primitive, boxed 스트림 양쪽에서 사용 가능
		//    리턴값: long
		// average()
		//    primitive stream 에서만 사용 가능.
		//    리턴값 Optional:  Optional<T>, OptionalInt, OptionalDouble ..

		System.out.println("-".repeat(30) +"\n▶ sum(), count(), average()");
		{
			customerList.forEach(System.out::println);

			// Customer 들의 나이의 합
			var result1 = customerList.stream() // Stream<Customer>
//					.mapToInt(Customer :: getAge) // IntStream (ok)
//					.mapToLong(Customer :: getAge) // LongStream (ok)
//					.map(Customer :: getAge) // Stream<Integer> (에러)
					.mapToDouble(Customer :: getAge) // DoubleStream (ok)
					.sum();

			System.out.println("sum() = " + result1);

			// 나이 40살 이상은 몇명?
			var result2 = customerList.stream()
					.filter(x -> x.getAge() >= 40)
					.count();

			System.out.println("count() = " + result2);

			// 평균 나이 구하기
			var result3 = customerList.stream() // Stream<Customer>
					.mapToInt(Customer :: getAge) // IntStream
					.average() // OptionalDouble
					.getAsDouble()
					;

			System.out.println("average() = " + result3);

			List<Customer> emptyList = new ArrayList<>(); // 비어있음
			var result4 = emptyList.stream() // Stream<Customer>
					.mapToInt(Customer :: getAge) // IntStream
					.average() // OptionalDouble.empty
//					.getAsDouble() // 죽음(NoSuchElementException)
					.orElse(0.0)
					;
			System.out.println("result4 = " + result4);

		}

		//---------------------------------------------------------------
		// min(), max()   [최종연산]
		//
		//  min(), max() 는 primitive, boxed 스트림 양쪽에서 사용 가능
		//    primitive 타입의 경우 max()에 파라미터가 없고, getXXX()를 이용해 반환 받을 수 있다.
		//    reference 타입인 경우 max()에 Comparator가 파라미터로 들어간다.
		// Optional 리턴:  Optional<T>, OptionalInt, OptionalDouble ..

		// System.out.println("-".repeat(30) +"\n▶ min(), max()");
		{
			// 1-1) 최대 나이값  (primitive)
			var maxAge1 = customerList.stream()
					.mapToInt(Customer :: getAge) // IntStream
					.max() // OptionalInt
					.getAsInt()
					;

			System.out.println("maxAge1 = " + maxAge1);

			// 1-2) 최대 나이값  (reference)
			var maxAge2 = customerList.stream()
					.map(Customer :: getAge) // Stream<Integer>
//					.max((o1, o2) -> o1.compareTo(o2)) // Optional<Integer>
					.max(Integer::compare) // int Integer.compare(o1, o2)
					.get()
					;

			System.out.println("maxAge2 = " + maxAge2);
		}

		//---------------------------------------------------------------
		// Match  [최종연산]
		// 스트림 연산 결과에 대해서 조건을 검사해 true/false로 리턴한다.
		//   매개변수: Predicate<T>
		//   anyMatch() : 조건을 충족하는 요소가 하나라도 있는 경우 true
		//   allMatch() : 모든 요소가 조건을 충족하는 경우 true
		//   noneMatch() : 모든 요소가 조건을 충족하지 않는경우 true

		 System.out.println("-".repeat(30) +"\n▶ **Match(Predicate<T>)");
		{

			//--------------------------------------------
			// Stream 은 내부반복 로직 수행
			// 기존 for, while 루프 대체

			System.out.println(stringList);
			System.out.println(match(stringList, "a"));
			// 이를 Stream 으로 작성하면..
			System.out.println(stringList.stream().anyMatch(str -> str.contains("a")));

			customerList.forEach(System.out::println);

			// 1) 이름에 "o"가 들어가는 사람이 한명이라도 있습니까? (anyMatch 사용)
			var anyMatch1 = customerList.stream()
					.anyMatch(customer -> customer.getName().contains("o"))
					;

			System.out.println("anyMatch1 = " + anyMatch1); // true

			// 2) 모든 사람의 이름에 "o" 가 있습니까? (allMatch 사용)
			var allMatch1 = customerList.stream()
					.allMatch(customer -> customer.getName().contains("o"))
					;

			System.out.println("allMatch1 = " + allMatch1); // false

			// 3)  모든 사람의 나이가 25살 이상입니까?  (allMatch 사용)
			var allMatch2 = customerList.stream()
					.allMatch(customer -> customer.getAge() >= 25)
					;

			System.out.println("allMatch2 = " + allMatch2); // false

			// 4) 어떤 사람의 이름도 10글자이상이 아닙니까?  (noneMatch 사용)
			var nonMatch1 = customerList.stream()
					.noneMatch(customer -> customer.getName().length() >= 10)
					;

			System.out.println("nonMatch1 = " + nonMatch1); // true
		}

		//-------------------------------------------------------
		// find   [최종연산]
		//
		//   findFirst() : 주어진 스트림에서 '순서상 첫번째' 원소를 리턴
		//   findAny() : 주어진 스트림에서 '가장 먼저' 탐색되는 원소 리턴  (병렬처리 환경)
		//
		//   리턴값: Optional
		//        Stream 에 원소가 없으면 empty 리턴
		//
		//   findFirst() 와 findAny() 의 차이점
		//     Stream 이 직렬로 처리될때는 둘다 동일 값 리턴
		//     Stream 을 병렬로 처리할때는 차이가 있을수 있다
		//         병렬로 처리하는 상황에선 findAny 는 '가장 먼저' 탐색되는 요소 리턴

		 System.out.println("-".repeat(30) +"\n▶ findFirst() findAny()");
		{
			// 1) 나이가 40 이상인 고객중 첫번째 고객
			var result1 = customerList.stream()
					.filter(x -> x.getAge() >= 40)
					.findFirst() // Optional<Customer>
					.get()
					;

			System.out.println("result1 = " + result1);
		}


		//---------------------------------------------------------------
		// Collecting   [최종연산]
		//
		// collect(Collector<T, A, R>)
		//    스트림 중간 연산을 결과를 Collector 형태의 파라미터를 받아
		//    다양한 형태로 결과를 만들어준다.
		//
		// Collector<T, A, R>
		//     T : 입력 요소 타입
		//     A : reduction 연산의 누적값 타입
		//     R : reduction 최종 결과 타입
		//
		// Collectors.toList(), Collectors.toMap(), Collectors.toSet()
		//     각각 연산의 결과를 List, Map, Set 으로 변환해 결과를 만든다.
		//

		 System.out.println("-".repeat(30) +"\n▶ collect(Collector<T, A, R>)");
		{
			List<Customer> personList = List.of(
					new Customer("zayson", 28),
					new Customer("chaeyoung", 26),
					new Customer("maeng", 30),
					new Customer("joon", 28)
			);
			personList.forEach(System.out::println);

			// 1) 이름만 List 로 뽑기
			List<String> nameList1 = personList.stream()
					.map(Customer :: getName) // Stream<String>
					.collect(Collectors.toList()) // Stream 에서 List 로  변환
					;

			System.out.println("nameList1 = " + nameList1);

			// 2) 나이대를 Set으로 뽑기
			Set<Integer> ageSet = personList.stream()
					.map(customer -> customer.getAge() / 10 * 10)  // Stream<Integer>
					.collect(Collectors.toSet()) // Stream 에서 Set 으로 변환
					;

			System.out.println("ageSet = " + ageSet);

			// 3) 이름-나이 로 Map 뽑기
			Map<String, Integer> personMapByName = personList.stream()
					.collect(Collectors.toMap(Customer :: getName, Customer :: getAge )) // key value, Map<String, Integer>
					;

			System.out.println("personMapByName = " + personMapByName);

			// key 가 중복되는 경우 IllegalStateException: Duplicate key maeng (attempted merging values 30 and 28)
			// 이런 경우는 BinaryOperator 이용해서 덮어쓰기
			var personMapByAge = personList.stream()
					.collect(Collectors.toMap(Customer :: getAge, Customer :: getName, (oldValue, newValue) -> newValue))
					// 동일한 key 값인 경우 새로운 value 로 덮어쓰기
					;

			System.out.println("personMapByAge = " + personMapByAge);

			// Collectors.joining()은 연산한 결과가 String 타입일 때 여러 결과 문자열을 하나로 합쳐주는 역할을 한다.
			//    파라미터가 없는 경우 : 문자열을 그대로 이어붙힌다.
			//    파라미터가 1개인 경우 (delimiter) : 각 문자열 사이에 구분자를 넣을 수 있다.
			//    파라미터가 3개인 경우 (delimiter, prefix, suffix) : 각 문자열 사이에 구분자를 넣고, 하나로 합쳐진 문자열 앞뒤에 문자열을 추가해 붙힌다.

			// 4) 이름을 뽑아 다양한 형태로 이어붙히기
			// 연산한 문자열을 하나의 문자열로 이어붙힌다.
			var name1 = personList.stream()
					.map(Customer :: getName) // Stream<String>
					.collect(Collectors.joining())
					;

			System.out.println("name1 = " + name1);

			var name2 = personList.stream()
					.map(Customer :: getName) // Stream<String>
					.collect(Collectors.joining(" / "))
					;

			System.out.println("name2 = " + name2);

			var name3 = personList.stream()
					.map(Customer :: getName) // Stream<String>
					.collect(Collectors.joining(" / ", "[", "]"))
					;

			System.out.println("name3 = " + name3);

			// Collectors.summarizingInt(), Collectors.summingInt(), Collectors.averagingInt()
			//   통계를 내어 최대값, 최소값, 개수, 합계, 평균을 구하거나
			//   직접 합계나 평균을 구하는 것이 가능하다.
			// Int, Double, Long 모두 지원

			// 5) 합계, 평균, 통계를 이용한 계산
			// TODO

			// Collectors.groupingBy()는 파라미터로 그룹핑 할 기준을 정해주면 해당 기준으로 데이터를 그룹핑한다.
			// 6) 데이터 그룹핑 (나이기준으로 데이터 그룹핑)
			// TODO

			// Collectors.partitioningBy()는 파라미터로 Predicate를 받는다.
			// 따라서, 해당 조건을 통해 나온 True/False를 기준으로 결과 데이터를 두 파티션으로 나눈다.
			// 7-1)이름이 5글자보다 많은 경우 구분
			// TODO

			// 7-2) 나이가 28살이 아닌 사람 구분
			// TODO
		}

		System.out.println("\n프로그램 종료");
	} // end main

	public static boolean match(List<String> list, String match){
		for (String string : list) {
			if (string.contains(match)) {
				return true;
			}
		}
		return false;
	} // end match()



} // end class





