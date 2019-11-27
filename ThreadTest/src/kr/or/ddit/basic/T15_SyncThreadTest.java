package kr.or.ddit.basic;

public class T15_SyncThreadTest {

	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		WorkerThread th1 = new WorkerThread("1번쓰레드", sObj);
		WorkerThread th2 = new WorkerThread("2번쓰레드", sObj);
		
		th1.start();
		th2.start();

	}

}
//공통으로 사용할 객체

class ShareObject{
	private int sum = 0;
	
		//동기화하는방법1 : 메서드 자체에 동기화설정하기
		//synchronized public void add() {//깔끔하게 출력되지만 속도가 많이 느려진다. 필수일때말곤 잘..
		
		public void add() {
		//동기화 처리 전까지 시간벌기용
		for(int i=0; i<1000000000; i++) {}
	
		//동기화 하는 방법2 : 동기화 블럭으로 설정하기.
		//				   내가 원하는 부분만 동기화처리 할 수 있다.
		synchronized (this) {
			
			int n = sum;
			
			n+=10; //10증가
			
			sum = n;
		}
		
		System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
	
	}

	public int getSum() {
		return sum;
	}

	
}

	//작업을 수행하는 쓰레드.
	class WorkerThread extends Thread {
		ShareObject sObj;
		
		public WorkerThread(String name, ShareObject sObj) {
			super(name);
			this.sObj = sObj;
	}

		@Override
		public void run() {
			for(int i=1; i<=10; i++) {
				sObj.add();
		}
	}
}



























