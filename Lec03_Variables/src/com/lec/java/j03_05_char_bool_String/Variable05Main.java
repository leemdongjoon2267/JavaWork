package com.lec.java.j03_05_char_bool_String;

public class Variable05Main {

    public static void main(String[] args) {

        // char : 문자 하나를 저장하기 위한 자료 타입(2바이트)
        //char 는 문자의 코드값(정수)가 담긴다(2바이트)

        char ch1 = 'A';
        // 문자열(String)은 큰따옴표("")로 묶어 줌.   (String literal)
        // 문자 하나(char)는 작은따옴표('')로 묶어 줌.   (char literal)

        //char ch2 = 'A';

        System.out.println("ch1 : " + ch1);

        char ch2 = '한';
        char ch3 = '글';

        System.out.println(ch2);
        System.out.println(ch3);

        char ch4 = 0xAE01;
        System.out.println(ch4);

        char ch5 = 33;
        System.out.println("ch5 : " + ch5);

        // 1. "bible"
        // 2. "cable"
        // 3. "able"
        // 오름차순 정렬하면?

        // 1. "aaAA"
        // 2. "AaAa"
        // 3. "aAaA"
        // 4. "AAaa"
        // 4 > 2 > 3 > 1

        char ch8 = 'A';
        char ch9 = 'a';

        System.out.println("A :  " + ch8);
        System.out.println("a :  " + ch9);

        System.out.println("A :  " + (int)ch8); // 65
        System.out.println("a :  " + (int)ch9); // 97

        // boolean(논리형) : 참(true), 거짓(false)
        boolean b1 = true;
        boolean b2 = false;

        System.out.println();
        System.out.println("b1 : " + b1);
        System.out.println("b2 : " + b2);

        System.out.println(10 < 20);

        // String 타입
        // String 은 primitive type 아님
        String name = "Hong";
        String nick = "thunder";
        System.out.println("이름은 : " + name + "\n별명은 : " + nick);

        // ---------------------------------------------
        // TextBlock : Java15 이상
        //   - TextBlock 안에서는 굳이 " 을 escaping 하지 않아도 된다.
        System.out.println("\nTextBlock (Java15이상)");


        /* 만약 아래 내용을 String 으로 만드려면?
        <html>


           <body>
              <span>example text</span>
           </body>
        </html>
        */

        // 기존의 String 이라면 이와 같이 \n \t 등을 꾸덕꾸덕 붙여야 한다.
        String txt1 = "<html>\n" +
                "\t\n" +
                "\t<body>\n" +
                "\t\t<span>example text</span>\n" +
                "\t</body>\n" +
                "</html>";
        System.out.println(txt1);

        String txt2 = """
                Example Text""";
        System.out.println(txt2);

        String txt3 = """
                <html>
                      "escaping" 안해도됨          
                                
                           <body>
                              <span>example text</span>
                           </body>
                        </html>""";

        System.out.println(txt3); // 텍스트 블럭에서는 "escaping" 안해도됨

    } // end main()
} // end class
