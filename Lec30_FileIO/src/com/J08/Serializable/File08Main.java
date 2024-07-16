package com.J08.Serializable;

import java.io.*;

/* Object Filter Stream
 Program <=== ObjectInputStream <=== FileInputStream <=== File
 Program ===> ObjectOutputStream ===> FileOutputStream ===> File

java.lang.Object
 └─ java.io.OutputStream
    └─ java.io.ObjectOutputStream
 
java.lang.Object
 └─ java.io.InputStream
     └─ java.io.ObjectInputStream


 Object Stream: 객체의 입출력을 위한 스트림
 사용법은 다른 Filter Stream(Buffered I/O, Data I/O)과 비슷
 Object 스트림의 입출력 대상이 되는 클래스는 Serializable 인터페이스를 구현
 클래스의 일부 멤버 변수를 직렬화(Serialization)의 대상에서 제외시키려면,
 transient 키워드를 사용
*/
public class File08Main {
	
	public static final String FILEPATH  = "temp/member.dat";

	public static void main(String[] args) {
		System.out.println("Object Filter Stream");

		// 객체를 파일에 저장하거나 네트워크를 통해 전송할 때 객체를 직렬화하여 바이트 스트림으로 변환

		try(
				OutputStream out = new FileOutputStream(FILEPATH);
				ObjectOutputStream oout = new ObjectOutputStream(out); // 장착
				InputStream in = new FileInputStream(FILEPATH);
				ObjectInputStream oin = new ObjectInputStream(in); // 장착
				){
			// 파일에 쓸 데이터 객체 생성
			Member m1 = new Member("root", "root1234");
			Member m2 = new Member("guest", "guest");
			Member m3 = new Member("admin", "admin123456");

			oout.writeObject(m1);
			oout.writeObject(m2);
			oout.writeObject(m3);
			// 파일로 저장이 됨

			// 저장된 파일을 읽어들임
			// 파일에서 Object 타입으로 읽기
			Member dateRead;

//			dateRead = (Member) oin.readObject(); // readObject 는 Object 타입으로 리턴해서 다운캐스팅
//			dateRead.displayInfo();
//			dateRead = (Member) oin.readObject();
//			dateRead.displayInfo();
//			dateRead = (Member) oin.readObject();
//			dateRead.displayInfo();

			// 방법2 : 무한루프로 readObject() 호출하고  EOFException 으로 잡기.
			// EOFException 으로 끝까지 read한것을 체크
			// EOF : End Of File

			// 무한루프 사용
			while(true){
				dateRead = (Member) oin.readObject();
				dateRead.displayInfo();
			}

		} catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException e){
			System.out.println("파일 끝까지 읽었습니다");
		}catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
















