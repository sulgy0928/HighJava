package kr.or.ddit.basic;
/*
  	Thread의 stop()메서드를 호출하면 쓰레드가 바로 멈춘다.
  	이때, 사용하던 자원을 정리하지 못하고 프로그램이 종료되어서 
  	나중에 실행되는 프로그램에 영향을 줄 수 있다.
  	그래서 현재는 stop()메서드는 비추천한다.
  	
*/
public class T13_ThreadStopTest {

	public static void main(String[] args) {
		ThreadStopEx1 th = new ThreadStopEx1();
		th.start();
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		//th.stop();
		th.setStop(true);
		
		//interrupt()메서드를 이용한 쓰레드 멈추기
		ThreadStopEx2 th2 = new ThreadStopEx2();
		th2.start();
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		th2.interrupt(); //interrupt() 메서드 호출
	}

}

class ThreadStopEx1 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
@Override
public void run() {
	while(!stop) {
		System.out.println("쓰레드 정리 중...");
	}
		System.out.println("자원 정리중...");
		System.out.println("실행 종료.");
	}
}


//interrupt() 메서드를 이용하여 쓰레드를 멈추게 하는 방법
class ThreadStopEx2 extends Thread{
	
	@Override
	public void run() {
		//방법1 => sleep() 메서드나 join()메서드 등을 사용했을떄
		//			interrupt()메서드를 호출하면 InterruptedException이 
		//			발생한다.
		
		try {
			while(true) {
				System.out.println("쓰레드 처리중...");
				Thread.sleep(1);
			}
		}catch(InterruptedException e) { //예외시키는방법으로 프로그램 빠져나와 종료시키기.
			//방법 2 => interrupt()메서드가 호출되었는지 검사하기.
		
		while(true) {
			System.out.println("쓰레드 처리중...");
			
			// 검사방법1 => 쓰레드의 인스턴스객체용 메서드를 이용하는방법
			if(this.isInterrupted()) { //interrupt()메서드가 호출되면 true
				System.out.println("인스턴스용 isInterrupted()");
				break;
			}
		}
		/*// 검사방법2 => 쓰레드의 정적 메서드를 이용하는 방법
		if(Thread.interrupted()) { //interrupt()가 호출되면 true
			System.out.println("정적메서드 interrupted()");
			break;
			
		}*/
		
		}
	System.out.println("자원정리중...");
	System.out.println("실행 종료.");
	
	
	
	}
}























































