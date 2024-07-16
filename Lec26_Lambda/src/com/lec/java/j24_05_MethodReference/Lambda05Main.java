package com.lec.java.j24_05_MethodReference;

/***
 * Method Reference (메소드 레퍼런스)
 *
 *   람다표현식에서 '메소드 호출 1회'로 코드가 끝나는 경우 '메소드 레퍼런스'를 이용하면 훨씬 코드가 간략화된다.
 *
 *  1) static 메소드 레퍼런스
 *     호출하고자하는 정적 클래스::메서드명
 *
 *  2) 매개변수의 인스턴스 메소드 레퍼런스
 *     매개변수 타입이 명확할때 해당 타입 클래스::메서드명
 *
 *  3) 생성자 메소드 레퍼런스
 *     리턴하여야 하는 타입명::new;
 *
 *  4) 외부 인스턴스 메소드 레퍼런스
 *     람다 캡쳐링(Lambda capturing) 을 이용해 람다표현식 바깥에 있는 인스턴스의 메소드를 호출할때 사용
 *
 *  내부적으로는 익명객체의 레퍼런스가 전달된다)
 *
 *  메소드 레퍼런스는 사용할수 있는 경우에 따라 사용법과 추론법이 약간 다르다
 */


import java.util.Arrays;
import java.util.List;
import java.util.function.*;


public class Lambda05Main {
    public static void main(String[] args) {

        {
            List<String> list = Arrays.asList("이승호", "허지우", "권희수");
            // 1.익명클래스 사용
            list.forEach(new Consumer<String>() { // forEach 의 매개변수는 Consumer
                @Override
                public void accept(String s) {
                    System.out.println(s);
                }
            });

            // 2. 람다 사용
            list.forEach(s -> System.out.println(s));

            // 3. 메소드레퍼런스 사용
            list.forEach(System.out::println);
        }

        System.out.println("-".repeat(30) + "\n▶ Static method reference");
        {
            Function<String, Integer> f = str -> Integer.parseInt(str);  // 메소드호출 1회로 끝나는 람다표현식

            // static 메소드 레퍼런스 사용
            f = Integer::parseInt; // Integer.parseInt(str) 랑 같음

            Integer result = f.apply("1");
            System.out.println(result);
        }

        {
            Consumer<String> c = str -> System.out.println(str); // 메소드호출 1회로 끝나는 람다표현식

            // static 메소드 레퍼런스 사용
            c = System.out::println; // System.out.println(str) 랑 같음

            c.accept("hello method reference");
        }

        System.out.println("-".repeat(30) + "\n▶ Instance method reference");
        {
            Function<String, Boolean> f = str -> str.isEmpty(); // 메소드호출 1회로 끝나는 람다표현식

            // 인스턴스 메소드 레퍼런스 사용
            f = String::isEmpty; // str.isEmpty() 랑 같음

            Boolean result = f.apply("hello");
            System.out.println(result);
        }

        {
            Predicate<String> p = str -> str.isEmpty(); // 메소드호출 1회로 끝나는 람다표현식

            // 인스턴스 메소드 레퍼런스
            p = String::isEmpty; // str.isEmpty() 랑 같음

            boolean result = p.test("hello");
            System.out.println(result);
        }

        {
            UnaryOperator<String> u = str -> str.toUpperCase(); // 메소드호출 1회로 끝나는 람다표현식

            // 인스턴스 메소드 레퍼런스
            u = String::toUpperCase; // str.toUpperCase() 랑 같음

            String result = u.apply("hello method reference");
            System.out.println(result);
        }

        System.out.println("-".repeat(30) + "\n▶ Constructor method reference");
        {
            Supplier<String> s = () -> new String();

            // 생성자 메소드 레퍼런스 사용
            s = String::new; //new String() 랑 같음

            String result = s.get();
            System.out.println("결과 [" + result + "]");
        }

        System.out.println("-".repeat(30) + "\n▶ Outer Object method reference");
        {
            String str = "hello";
            Predicate<String> p;
            p = s -> str.equals(s);  // 외부 캡쳐링 (람다 내부에서 외부 인스턴스 참조)

            // 외부인스턴스 str 을 사용한 메소드 레퍼런스
            p = str::equals;

            boolean result = p.test("hello");
            System.out.println(result);
        }

    } // end main

} // end class
