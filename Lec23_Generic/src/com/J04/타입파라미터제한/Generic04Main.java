package com.J04.타입파라미터제한;

//      와일드 카드 <?>
//		upper-bounded <? extends Number>
//		lower-bounded <? super Integer>
//		generic 사용 <? extends T>

public class Generic04Main {
    public static void main(String[] args) {
        System.out.println("\n타입 파라미터 제한");


//        test1(new A()); // A 는 B를 상속받지 않아서 오류
        test1(new B());
        test1(new C());
        test1(new D());

        System.out.println();
        test2(new Box<A>());
        test2(new Box<B>());
        test2(new Box<C>());
        test2(new Box<D>());

        System.out.println();
//        test3(new Box<A>()); // 에러
        test3(new Box<B>());
        test3(new Box<C>());
        test3(new Box<D>());

        System.out.println();
        test4(new Box<A>());
        test4(new Box<B>());
        test4(new Box<C>());
//        test4(new Box<D>()); // 에러

        // -----------------------------
        // 제네릭은 공변성(covariance) 이 없다
        // 공변성?

        A a = new A();
        B b = new B();
        a = b; // 다형성으로 인해 가능, 공변성이 있다
//        b = a; // 에러
        b = (B)a; // 반공병성(Contravariance)이 있다

        // 배열의 경우
        Object[] arr = new Object[10];
//        Object[] arr = new Integer[10]; // 가능(공변성이 있다)
        Integer[] arr2 = (Integer[]) arr; // 반공병성이 있다

        // Generic 의 경우
        Box<A> boxA = new Box<>();
        Box<B> boxB = new Box<>();
//        boxA = boxB; // 공변성 없다
//        boxA = (Box<A>)boxB;

        System.out.println("\n프로그램 종료");
    } // end main()

    // B 또는 B 를 상속받은 객체들만 가능
    public static <T extends B> void test1(T param){
        System.out.println(param.getClass());
    }


    // ? : 어떠한 타입이든 상관없음
    public static void test2(Box<?> box){}
    public static void test3(Box<? extends B> box){}

    // C 이거나 C의 상위쪽만 가능
    public static void test4(Box<? super  C> box){}

} // end class


class A {}
class B extends A{}
class C extends B{}
class D extends C{}

class Box<T>{
}
