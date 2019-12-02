package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 소켓에서 메세지를 받아 화면에 출력하는 역할을 담당한다.
 * @author pc08
 *
 */
public class Receiver extends Thread{
	Socket socket;
	DataInputStream dis;
	
	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			dis = new DataInputStream(socket.getInputStream());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(dis != null) { //dis객체가 제대로 생성된 경우.
			try {
				System.out.println(dis.readUTF());
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}

















