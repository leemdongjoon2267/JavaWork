package com.J03.클래스의List;

import dataset.DataSet;
import dataset.Score;
import dataset.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("List 연습");

		// Student를 저장할 수 있는 ArrayList 인스턴스 생성
		List<Student> students = DataSet.students; // 10명의 학생정보

		for(var e : students) System.out.println(e);  // 일단 출력

		//------------------------------------------------------------
		// 김동혁 학생의 정보 수정 (김동혁 학생이 List의 몇번째 저장되었는지 모른다고 하면?)
		// id 값 -> "D002"
		// 국어, 영어, 수학 -> 99, 88, 76
		System.out.println("\n학생 정보 수정");
		{
			for (int i = 0; i < students.size(); i++) {
				Student stu	= students.get(i);
				if("김동혁".equals(stu.getName())){
					System.out.println("수정전: " + stu);
					// 김동혁 이라는 이름이 일치하면
					// Id를 D002로 바꾸고
					// 점수를 가져와서 국어, 영어, 수학 점수를 변경

					stu.setId("D002");
					stu.getScore().setKorean(99);
					stu.getScore().setEnglish(88);
					stu.getScore().setMath(77);

					System.out.println("수정후: " + stu);
					break;
				}
			}
		}

		//------------------------------------------------------------
		// 1학년 과 3학년 출력하세요
		// 출력예시]
		//		Student{id='S001', name='김남승', grade=3, major='Software', score=[국:100,영: 90,수: 80]}
		//		Student{id='D002', name='김동혁', grade=3, major='Design', score=[국: 99,영: 88,수: 76]}
		//		Student{id='S006', name='Clint', grade=3, major='Software', score=[국: 99,영: 80,수: 21]}
		//		Student{id='T001', name='Peter', grade=1, major='Theater', score=[국: 59,영: 88,수: 21]}
		System.out.println("\n1학년, 3학년 학생 출력");
		{
			for (int i = 0; i < students.size(); i++) {
				Student stu = students.get(i);
				if(stu.getGrade() == 1 || stu.getGrade() == 3){
					System.out.println(students.get(i));
				}
			}
		}

		//------------------------------------------------------------
		// 3학년 이상의 학생이 몇명인지 출력하세요
		//  출력예시]
		// 		6명
		System.out.println("\n3학년 이상 학생수");
		{
			int count = 0;
			for (int i = 0; i < students.size(); i++) {
				Student stu = students.get(i);
				if(stu.getGrade() >= 3){
					count++;
				}
			}
			System.out.println(count);
		}

		//------------------------------------------------------------
		// 각 전공별로 학생이 몇명인지 출력해보세요
		// 출력예시]
		// 	SoftWare: 6
		// 	Design: 2
		// 	Theater: 1
		// 	Advertisement: 1
		System.out.println("\n전공별 학생수");
		{
			int Software = 0;
			int Design = 0;
			int Theater = 0;
			int Advertisement = 0;
			for (int i = 0; i < students.size(); i++) {
				Student stu = students.get(i);
				String Major = stu.getMajor();
				if(stu.getMajor().equals("Software")){
					Software++;
				}
			}
			System.out.println("Software: " + Software);

			for (int i = 0; i < students.size(); i++) {
				Student stu = students.get(i);
				String Major = stu.getMajor();
				if(stu.getMajor().equals("Design")){
					Design++;
				}
			}
			System.out.println("Design: " + Design);

			for (int i = 0; i < students.size(); i++) {
				Student stu = students.get(i);
				String Major = stu.getMajor();
				if(stu.getMajor().equals("Theater")){
					Theater++;
				}
			}
			System.out.println("Theater: " + Theater);

			for (int i = 0; i < students.size(); i++) {
				Student stu = students.get(i);
				String Major = stu.getMajor();
				if(stu.getMajor().equals("Advertisement")){
					Advertisement++;
				}
			}
			System.out.println("Advertisement: " + Advertisement);


		}

		// 평균의 최댓값, 최솟값 을 출력해보세요
		//
		// [출력예시]
		// 	Max: 99.0
		// 	Min: 43.7
		System.out.println("\n평균 의 최댓값, 최솟값");
		{
			double maxAvgScore = 0.0, minAvgScore = 100.0;
			for(Student stu : students){
				double avg = (stu.getScore().getKorean() + stu.getScore().getEnglish() + stu.getScore().getMath()) / 3.0;
				if(avg > maxAvgScore)	maxAvgScore = avg;
				if(avg < minAvgScore) 	minAvgScore = avg;
			}
			System.out.printf("Max: %.1f\n", maxAvgScore);
			System.out.printf("Min: %.1f\n", minAvgScore);

		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









