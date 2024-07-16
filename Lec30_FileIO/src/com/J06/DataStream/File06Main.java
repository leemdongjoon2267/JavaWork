package com.J06.DataStream;

/*  Data Filter Stream
 Program <=== DataInputStream <=== FileInputStream <=== File
 Program ===> DataOutputStream ===> FileOutputStream ===> File

java.io.InputStream
|__ java.io.FilterInputStream
   |__ java.io.DataInputStream  

java.io.OutputStream
|__ java.io.FilterOutputStream
   |__ java.io.DataOutputStream

   Java 의 data 를 입출력하는 용도로 사용 (ex: int, double...)
*/

import java.io.*;

public class File06Main {

    public static void main(String[] args) {
        System.out.println("Data Filter Stream");

        try (
                OutputStream out = new FileOutputStream("temp/data.bin");
                DataOutputStream dout = new DataOutputStream(out); // 장착

                InputStream in  = new FileInputStream("temp/data.bin");
                DataInputStream din = new DataInputStream(in); // 장착
        ) {
            dout.writeBoolean(true); // 1byte
            dout.writeInt(100); // 4byte
            dout.writeDouble(3.14); // 8byte
            dout.writeChar('A'); // 2byte

            // 총 15 byte 저장

            boolean b = din.readBoolean();
            System.out.println(b);

            int num1 = din.readInt();
            System.out.println(num1);

            double num2 = din.readDouble();
            System.out.println(num2);

            char ch = din.readChar();
            System.out.println(ch);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n프로그램 종료");

    } // end main()

} // end class
















