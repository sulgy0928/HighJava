package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 기본타입 입출력 보조스트림 예제
 *
 */
public class T13_DataIOStreamTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("d:/D_Other/test.dat");
			
			// DataOutputStream 은 출력용 데이터를 자료형에 맞게 출력해준다.
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeUTF("홍길동"); 		// 문자열 데이터 출력(UTF-8)
			dout.writeInt(17);			//정수형으로 데이터출력
			dout.writeFloat(3.14f);		//실수형(float)로 출력
			dout.writeDouble(3.14);		//실수형(Double)로 출력
			dout.writeBoolean(true);	// 논리형으로 출력.
			System.out.println("출력완료..");
			
			// 저장한대로 읽지 않으면 아무리 잘짰어도 꼬여서 에러남.
			// 물론 작성도 필요 타입별로 잘 작성해야함 ^ㅅ^ 
			dout.close();
			//=====================================================================//
			//=====================================================================//
			//출력한 자료 읽어오기
			FileInputStream fin = new FileInputStream("d:/D_Other/test.dat");
			DataInputStream din = new DataInputStream(fin);
			
			System.out.println("문자열 자료 : " + din.readUTF());
			System.out.println("정수형 자료 : " + din.readInt());
			System.out.println("실수형(float) 자료 : " + din.readFloat());
			System.out.println("실수형(Double) 자료 : " + din.readDouble());
			System.out.println("논리형 자료 : " + din.readBoolean());
			
			din.close();
			
			}catch(IOException e) {
				e.printStackTrace();
		}
	}
}



























