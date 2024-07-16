package com.J04.FilterStream;

/* 보조스트림 (filter stream)
Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
Program <=== BufferedInputStream <=== FileInputStream <=== File

Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
Program ===> BufferedOutputStream ===> FileOutputStream ===> File

java.io.InputStream
 |__ java.io.FilterInputStream
      |__ java.io.BufferedInputStream

java.io.OutputStream
 |__ java.io.FilterOutputStream
      |__ java.io.BufferedOutputStream

참고 ) 보조스트림 (filter stream)
보조스트림(filter stream) 이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림
*/

import java.io.*;

public class File04Main {

	public static void main(String[] args) {
		System.out.println("BufferedInputStream, BufferedOutputStream");

		InputStream in  = null;
		BufferedInputStream bin  = null; // 기존의 InputStream 에 장착
		OutputStream out = null;
		BufferedOutputStream bout = null;

		// UnHandle Exception 으로 인한 try catch
		try {
			// InputStream 생성
			in = new FileInputStream("temp/big_text.txt");
			bin = new BufferedInputStream(in); // 장착
			// OutputStream 생성
			// FileOutputStream 인스턴스 생성
			// 해당 파일이 없으면, 새로 생성.
			//   ..      있었으면, 지우고 새로 생성.
			out = new FileOutputStream("temp/copy_big_text.txt");
			bout = new BufferedOutputStream(out); // 장착

			int dataRead;
			int bytesCopied = 0;
			long startTime = System.currentTimeMillis();


			while(true){

				dataRead = bin.read();
				if(dataRead == -1){ // 더이상 읽어들일 byte 가 없으면 read() 는 -1 을 리턴
					break;
				}


				bout.write(dataRead);
				bytesCopied ++;
			} // end while

			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime; // 경과시간


			System.out.println("읽고 쓴 바이트: " + bytesCopied); // 총 읽고 쓴 바이트의 개수
			System.out.println("경과시간(ms): " + elapsedTime);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			// 리소스 해제.
			try {
				// filter stream 을 close() 하면 장착된 Input/Output Stream 도 함께 close() 됨.
				if(bout != null) bout.close();
				if(bin != null) bin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class














