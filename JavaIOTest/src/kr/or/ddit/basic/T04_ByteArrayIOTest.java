package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04_ByteArrayIOTest {

	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; // 자료를 읽을 때 사용할 배열
		
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		try {
			//available() => 읽어 올 수 있는 byte 수를 반환
			while(input.available() > 0) {
//				input.read(temp); //temp 배열 크기만큼 읽어와 temp에 저장
//				output.write(temp); //temp배열 내용 출력
				
				//실제 읽어온 byte 수를 반환한다.
				int len = input.read(temp);
				
				//temp배열의 내용 중 0번째부터 len갯수만큼 출력한다.
				output.write(temp, 0,len); // 얘덕분에 이제 쓰레기데이터를 제외한 나머지의
										  // 우리가 원하는 값 만을 출력하는 데 성공.
				
				
				System.out.println("temp : " + Arrays.toString(temp));
			}
		System.out.println();
		outSrc = output.toByteArray(); //쓰레기값 두개를(끝에 6 7)같이출력해버림.
		
		System.out.println("inSrc => " + Arrays.toString(inSrc));
		System.out.println("outSrc => " + Arrays.toString(outSrc));
		
		input.close();
		output.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}


























