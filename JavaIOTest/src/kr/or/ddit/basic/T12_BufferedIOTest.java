package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *  문자기반의 Bufferd 스트림 사용 예제
 *
 */
public class T12_BufferedIOTest {

	public static void main(String[] args) {
		try {
			// 이클립스에서 만든 자바프로그램이 실행되는 기본 위치는 
			// 해당 '프로젝트폴더' 가 기본위치가 된다.
			FileReader fr = new FileReader("./src/kr/or/ddit/basic/T11_BufferedIOTest.java");
		
//			int c;
//			while((c=fr.read())!= -1) {
//				System.out.println((char)c);
//			}
		
			//한줄씩 읽을 수 있도록 해주는 readLine()메서드를 이용하기 위해
			//BufferedReader 사용
			BufferedReader br = new BufferedReader(fr);
			String temp = "";
			int i=1;
			while((temp = br.readLine()) != null) {
				System.out.printf("%4d : %s\n", i, temp);
				i++;
			}
			
			br.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
