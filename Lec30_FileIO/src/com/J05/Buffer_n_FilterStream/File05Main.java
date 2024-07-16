package com.J05.Buffer_n_FilterStream;

/* Buffered Stream + Buffer 예제
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
*/

import java.io.*;

public class File05Main {

	public static void main(String[] args) {
		System.out.println("Buffered Stream + Buffer");
		
		// TODO:
		// file03 패키지 참조
		// try with resource 구문으로 작성
		// in.read(buff) --> bin.read(buff);
		// out.write( , , ) --> bout.write( , , ); 사용
		// finally 필요 없슴


		try(
				InputStream in = new FileInputStream("temp/big_text.txt");
				BufferedInputStream bin = new BufferedInputStream(in); // 장착
				OutputStream out = new FileOutputStream("temp/copy_big_text.txt");
				BufferedOutputStream bout = new BufferedOutputStream(out); // 장착
		){
			byte[] buff = new byte[1024]; // 버퍼 준비
			int lengthRead; // 읽어들인 바이트 개수
			int bytesCopied = 0;
			long startTime = System.currentTimeMillis();

			while(true){

				// 매개변수로 주어진 byte[] 배열의 길이 만큼 read 한다.
				// 실제 읽어 들인 데이터는 매개변수 byte[] 에 담김.
				// 읽어들인 바이트 개수 리턴,  읽어들인게 없으면 -1 리턴.
				lengthRead = bin.read(buff); // 읽어들인 byte 의 개수를 리턴
				if(lengthRead == -1){ // 더이상 읽어들일 byte 가 없으면 read() 는 -1 을 리턴
					break;
				}

				bout.write(buff, 0, lengthRead); // 직전에 읽어들인 데이터 만큼 쓰기
				bytesCopied += lengthRead; // 읽어들인 바이트의 개수만큼 증가
			} // end while

			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;


			System.out.println("읽고 쓴 바이트: " + bytesCopied); // 총 읽고 쓴 바이트의 개수
			System.out.println("경과시간(ms): " + elapsedTime);

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("\n프로그램 종료");

	} // end main()

} // end class File05Main
















