package com.J02.ReadWrite;

/* FileIO
 Program <=== InputStream <=== Source
 Program ===> OutputStream ===> Source
 Program <=== FileInputStream <=== File
 Program ===> FileOutputStream ===> File

 java.io.InputStream
  |__ java.io.FileInputStream: 파일로부터 데이터를 읽어오는 통로
 java.io.OutputStream
  |__ java.io.FileOutputStream: 파일로 데이터를 쓰는 통로
*/

import java.io.*;

public class File02Main {

	public static void main(String[] args) {
		System.out.println("File IO");

		InputStream in  = null;
		OutputStream out = null;

		// UnHandle Exception 으로 인한 try catch
        try {
			// InputStream 생성
            in = new FileInputStream("temp/big_text.txt");
			// OutputStream 생성
			// FileOutputStream 인스턴스 생성
			// 해당 파일이 없으면, 새로 생성.
			//   ..      있었으면, 지우고 새로 생성.
			out = new FileOutputStream("temp/copy_big_text.txt");

            int dataRead;
            int bytesCopied = 0;
            long statTime = System.currentTimeMillis(); // 현재 시간 저장

			// 파일 복사 작업
            //  InputStream 에서 한 byte 씩 읽어 들어와서
            //  OutputStream 에 한 byte 씩 쓰기


            while(true){
                // 데이터 읽기: InputStream 에 있는 read() 메소드 사용
                // read()는 InputStream 으로부터
                // 1byte 씩 읽어서 int(4byte) 에 담아 리턴한다
                // [ ... ][ ... ][ ... ][ 1byte ]
                dataRead = in.read();
                if(dataRead == -1){ // 더이상 읽어들일 byte 가 없으면 read() 는 -1 을 리턴
                    break;
                }

                // 데이터 쓰기: OutputStream 에 있는 write() 메소드 사용
                // write() 는
                // int(4byte)에 1byte 씩 담아 OutputStream 에 쓴다
                // [ ... ][ ... ][ ... ][ 1byte ]
                out.write(dataRead); // 위에서 읽어서 write 에서 씀
                bytesCopied ++;
            } // end while

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - statTime; // 경과시간


            System.out.println("읽고 쓴 바이트: " + bytesCopied); // 총 읽고 쓴 바이트의 개수
            System.out.println("경과시간(ms): " + elapsedTime);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
			// 리소스 해제.
            try {
               if(out != null) out.close();
			   if(in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class

