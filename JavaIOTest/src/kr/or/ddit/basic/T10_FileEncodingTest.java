package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class T10_FileEncodingTest {

	
/*
 		OutputStreamWriter 객체 => OutputStream(바이트기반의 출력용 객체)를
 								  Writer(문자기반의 출력용 객체)로 변환하는 객체.
 				=> 이 객체도 출력할 때, '인코딩 방식'을 지정해서 출력할 수 있다.
 				
 */
	public static void main(String[] args) throws IOException {
		//키보드로 입력한 내용을 파일로 저장하는데
		// out_utf8.txt 파일은 'utf-8' 인코딩 방식으로
		// out_ansi.txt 파일은 'ms949' 인코딩 방식으로 저장한다.
		
		//InputStreamReader 바이트 입력 스트림에 연결되어
		// 문자입력 스트림인 Reader로 변환시키는 보조스트림
		InputStreamReader isr = new InputStreamReader(System.in);
		
		//파일 출력용
		FileOutputStream fos1 = new FileOutputStream("d:/D_Other/out_utf8.txt");
			FileOutputStream fos2 = new FileOutputStream("d:/D_Other/out_ansi.txt");
			
			//OutputStreamWriter 는 바이트 출력 스트림에 연결되어 문자출력
			//스트림인 Writer 로 변환시키는 보조스트림.
			OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "utf-8");
			OutputStreamWriter osw2 = new OutputStreamWriter(fos2, "ms949");
			
			int c;
			
			System.out.println("아무거나 입력하세요.");
			
			while((c=isr.read())!= -1) {
				osw1.write(c);
				osw2.write(c);
			}
			System.out.println("작업완료.");
			
			isr.close();
			osw1.close();
			osw2.close();
	}
}






















