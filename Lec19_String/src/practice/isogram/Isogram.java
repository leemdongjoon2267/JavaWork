package practice.isogram;

import java.util.Locale;

/*******************************
 * isogram : 중복글자 없는 단어
 * isogram 여부 판단하기 (true/false)
 */

public class Isogram {

    public static final String[] input = {
            "Dermatoglyphics", // -> true
            "programmer",      // -> false
            "Cocktail",         // -> false  대소문자 동일
            "isogram",         // -> true
    };

    // main 은 수정하지 마세요
    public static void main(String[] args) {
        for (var word : input) {
            System.out.println(is_isogram(word));
        }
    }

    static boolean is_isogram(String str) {

        String notdistinct = str.toLowerCase(); // 대소문자 구별이 없으니 모두 다 소문자로 바꿔줌

        for (int i = 0; i < str.length() - 1; i++) {
            for(int j = 0; j < i; j++){
                if(notdistinct.substring(i+1).indexOf(notdistinct.charAt(i)) != - 1){
                    return false;
                }
            }
        }
        return true;

        // 다른 방법
        // true = 하나도 중복되지 않음
        // false = 중복되는 철자가 존재함

        // 철자를 전부 소문자로 변환
//        str = str.toLowerCase();
//
//        // 단어의 0번째 철자부터 마지막에서 하나 앞 철자까지 순회
//        for(int i = 0; i < str.length() - 1; i++) {
//
//            // 단어의 1번째 철자부터 마지막 철자까지 순회
//            for(int j = i + 1; j < str.length(); j++) {
//
//                // 중복되는 철자 발견 시 false 반환
//                if (str.charAt(i) == str.charAt(j))
//                    return false;
//            }
//        }
//
//        // 중복되는 철자가 없음
//        return true;
    }
}



