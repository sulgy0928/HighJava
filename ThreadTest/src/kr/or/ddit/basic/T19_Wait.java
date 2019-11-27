package kr.or.ddit.basic;
/*
   wait()메서드 => 동기화 영역에서 락을 풀고 Wait-Set영역으로 이동시킨다
   notify() 또는  notifyAll() 메서드
		
 */

/**
 * wait()와 notify()를 이용한 두 쓰레드가 번갈아가면서
 * 한번씩 실행하는 예제.
 * @author pc08
 *
 */
public class T19_Wait {

	public static void main(String[] args) {
	WorkObject workObj = new WorkObject();
	
	Thread thA = new ThreadA(workObj);
	Thread thB = new ThreadA(workObj);

	thA.start();
	thB.start();
	}
}

//공통으로 사용할 객체
class WorkObject {
	public synchronized void methodA() {
		System.out.println("methodA() 메서드 작업중...");
		
		notify();
		
		try {
			wait(); //대기실로 감.
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void methodB() {
		System.out.println("methodB() 메서드 작업중...");
		
		notify(); //잠자던 애 깨움.
		
		try {
			wait();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}	
	}
}

// WorkObject 의 methodA() 메서드만 호출하는 쓰레드
class ThreadA extends Thread {
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			workObj.methodB();
		}
	}
}



















