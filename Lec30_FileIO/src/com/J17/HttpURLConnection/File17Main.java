package com.J17.HttpURLConnection;

/* HTML 데이터, 웹데이터 (텍스트)
 * Java 에서 웹 연결을 위한 객체 두가지
 * 	URL : 웹 상의 주소,
 * 	HttpURLConnection : 웹연결
 * 		URLConnection
 * 		 └─ HttpURLConnection
 *
 * 	java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
 * 		├─ java.io.InputStreamReader    // 스트림 기반의 reader
 * 		└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class File17Main {

	public static void main(String[] args) {
		System.out.println("웹데이터 가져오기(텍스트)");

		String url_address = "https://www.daum.net";
//		StringBuffer sb = readFromUrl1(url_address);
//		System.out.println(sb);

		// Stream<T> 사용
		System.out.println(readFromUrl2(url_address));

		System.out.println("\n프로그램 종료");
	} // end main()

	private static StringBuffer readFromUrl1(String urlAddress) {
		StringBuffer sb = new StringBuffer();

		URL url = null;
		HttpURLConnection conn = null;

		InputStream in = null;
		InputStreamReader reader = null;   // 스트림기반의 reader
		BufferedReader br = null;

		char [] buff = new char[512];

		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection) url.openConnection();

			if(conn != null){
				// 실제 접속(요청:request) 하기 전에
				conn.setConnectTimeout(2000);
				// 2초 이내에 연결이 수립안되면 java.net.SocketTimeoutException  발생

				conn.setRequestMethod("GET");  // GET 방식 요청
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false);  // 캐시사용 안함.

				System.out.println("connect 시작: " + urlAddress);
				conn.connect();
				System.out.println("connect 완료");

				// 요청 수립후 서버로부터의 응답(response) 을 받음.
				int responseCode = conn.getResponseCode();  // response code
				System.out.println("response code : " + responseCode);  // 정상처리: 200, 2xx

				if(responseCode == HttpURLConnection.HTTP_OK) {

					in = conn.getInputStream();  // HttpURLConnection 으로부터 응답 데이터 받기위한 InputStream
					reader = new InputStreamReader(in, "utf-8");
					br = new BufferedReader(reader);

					int cnt;
					while((cnt = br.read(buff)) != -1){
						sb.append(buff, 0, cnt);
					}

				} else {
					System.out.println("response 실패");
					return null;
				}

			} else {
				System.out.println("conn null");
				return null;
			}

		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {

			try {
				if(br != null) br.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			if(conn != null) conn.disconnect();  // 종료전에 연결 반드시 해제.
		}


		return sb;
	}

	// Stream 을 사용하면 더욱 간단하게 작성 가능!
	private static String readFromUrl2(String urlStr){
		try{
			URL url = new URL(urlStr);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
			return br.lines().collect(Collectors.joining());
		}catch(IOException e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

} // end class
