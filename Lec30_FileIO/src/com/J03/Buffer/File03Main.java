package com.J03.Buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 java.io.InputStream
  |__ java.io.FileInputStream
 java.io.OutputStream
  |__ java.io.FileOutputStream
*/

public class File03Main {

	public static void main(String[] args) {
		System.out.println("File IO 2");
		
		// Java 7부터 도입된 try-with-resource
		// try (리소스 생성) { ... }
		// catch (exception ) { ... }
		// 리소스를 close하는 코드가 없어도 자동으로 close가 실행
		//
		// java.lang.AutoCloseable 나 
		//  └─ java.io.Closeable 을 상속받은 어떠한 객체라도 
		//  try(리소스 생성) 안에 '선언' 되어 있으면
		//  try~catch 가 끝나기 전에 close() 됨.
		
		// InputStream, OutputStream 둘다 Closeable 을 상속(implements) 한다
		
	
		try(
				InputStream in = new FileInputStream("temp/big_text.txt");
				OutputStream out = new FileOutputStream("temp/copy_big_text.txt");
				){
			byte[] buff = new byte[1024]; // 버퍼 준비
			int lengthRead; // 읽어들인 바이트 개수
			int bytesCopied = 0;
			long statTime = System.currentTimeMillis();

			while(true){

				// 매개변수로 주어진 byte[] 배열의 길이 만큼 read 한다.
				// 실제 읽어 들인 데이터는 매개변수 byte[] 에 담김.
				// 읽어들인 바이트 개수 리턴,  읽어들인게 없으면 -1 리턴.
				lengthRead = in.read(buff); // 읽어들인 byte 의 개수를 리턴
				if(lengthRead == -1){ // 더이상 읽어들일 byte 가 없으면 read() 는 -1 을 리턴
					break;
				}

				out.write(buff, 0, lengthRead); // 직전에 읽어들인 데이터 만큼 쓰기
				bytesCopied += lengthRead; // 읽어들인 바이트의 개수만큼 증가
			} // end while

			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - statTime;


			System.out.println("읽고 쓴 바이트: " + bytesCopied); // 총 읽고 쓴 바이트의 개수
			System.out.println("경과시간(ms): " + elapsedTime);

		} catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
















