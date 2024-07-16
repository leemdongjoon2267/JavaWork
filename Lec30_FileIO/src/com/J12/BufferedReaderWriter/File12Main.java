package com.J12.BufferedReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 버퍼사용 문자입출력 : BufferedReader, BufferedWriter
 * 
 * java.lang.Object
 *  └─ java.io.Reader
 *      └─ java.io.BufferedReader
 *       
 * java.lang.Object
 *  └─ java.io.Writer
 *      └─ java.io.BufferedWriter
 *      
 * ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★     
 *             
*/

/*
 * txt 는 utf-8 로 인코딩 , 영문 텍스트
 */
public class File12Main {
	
	private static final String BIG_TEXT = "temp/big_eng.txt"; 
	
	public static void main(String[] args) {
		System.out.println("BufferedReader / BufferedWriter");
		
		FileWriter fw = null;
		FileReader fr = null;

		BufferedWriter bw = null;
		BufferedReader br = null;

		int charRead = 0;  // 읽은 문자 (한개)
		int charsCopied = 0;  // 몇 문자 복사했는지
		long startTime, endTime, elapsedTime;  // 경과시간 체크

		try {
			System.out.println("FileReader/Writer 만 사용");

			fr = new FileReader(BIG_TEXT);
			fw = new FileWriter("temp/big_eng_copy1.txt");


//			while (true){
//				charRead = fr.read();
//				if(charRead == -1)break;
//			}
			// 위에꺼랑 같음
			charRead = 0; // 읽어낸 문자 (한개)
			charsCopied = 0; // 몇 문자를 복사했는지
			startTime = System.currentTimeMillis(); // 시간 측정
			while ((charRead = fr.read()) != -1){
				fw.write(charRead); // 한 글자 복사
				charsCopied ++;
			}
			fw.flush(); // 문자 출력 시 마지막에 꼭 flush() 를 하자,
						// flush 를 하지 않으면 정상적으로 복사가 끝나지 않는다.

			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;

			System.out.println("읽고 쓴 문자수: " + charsCopied);
			System.out.println("경과시간(ms): " + elapsedTime);

			System.out.println("BufferedReader/Writer + 버퍼 사용");

			//---------------------------
			fw.close();
			fr.close();
			//---------------------------

			fr = new FileReader(BIG_TEXT);
			fw = new FileWriter("temp/big_eng_copy2.txt");
			br = new BufferedReader(fr); // 장착
			bw = new BufferedWriter(fw); // 장착

			char[] buf = new char[1024]; // 버퍼도 제공

			int charsRead = 0; // 버퍼에 읽어들인 문장의 개수
			charsCopied = 0; // 몇 문자를 복사했는지
			startTime = System.currentTimeMillis(); // 시간 측정
			while ((charsRead = br.read(buf)) != -1){
				bw.write(buf, 0, charsRead); // 첫번째 부터
				charsCopied += charsRead;
			}
			bw.flush(); // 문자 출력 시 마지막에 꼭 flush() 를 하자,
			// flush 를 하지 않으면 정상적으로 복사가 끝나지 않는다.

			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;

			System.out.println("읽고 쓴 문자수: " + charsCopied);
			System.out.println("경과시간(ms): " + elapsedTime);

		} catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
			// TODO

		}

		System.out.println("\n프로그램 종료");
		
	} // end main()
} // end class
