package com.lec.java.j18_08_연습CustomException;

// TODO : Exception 상속받은 예외 클래스 만들기
public class AgeInputException extends Exception{

    public AgeInputException(){
        super("나이 입력 오류");
    }

	
} // end class AgeInputException
