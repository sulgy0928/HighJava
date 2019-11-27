 package kr.or.ddit.basic;

public class T09_ThreadDaemonTest {

	public static void main(String[] args) {
		AutoSaveThread autoSave = new AutoSaveThread();
		
		//데몬 쓰레드로 설정하기(start()메서드 호출하기 전에 설정한다.)
		autoSave.setDaemon(true);	//일반 쓰레드라면 프로그램이 종료되지 않고 계속 실행된다.
		autoSave.start();
		
		try {
			for(int i = 1; i<=20; i++) {
				System.out.println("작업 " + i);
				Thread.sleep(1000);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("메인 쓰레드 종료...");
	}
}


//자동 저장하는 기능을 제공하는 쓰레드 클래스
class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("작업한 내용을 저장합니다...");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			save(); //저장기능 호출
		}
	}
}
