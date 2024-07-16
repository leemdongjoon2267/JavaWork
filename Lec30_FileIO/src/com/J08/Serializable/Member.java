package com.J08.Serializable;

import java.io.Serializable;

public class Member implements Serializable {

	private String id;
	private String pw;
	transient private int num; // transient 를 붙이면 읽어들어올때 기본값으로 불러옴
	transient private boolean isExist;
	
	// transient 로 선언된 변수는 serialization(직렬화) 대상에서 제외됨.
	// (파일에 write 되지 않는다)
	// de-Serialization(역직렬화, 파일에서 읽기)를 할 때는
	// 해당 타입의 기본값(0, false, null)으로 초기화됨
	
	public Member() {}
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.num = 123;
		this.isExist = true;
	}
	
	public void displayInfo() {
		System.out.println("--- 회원 정보 ---");
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + pw);
		System.out.println("번호: " + num);
		System.out.println("Exist? " + isExist);
	}
	
} // end class Member 






