package kr.or.ddit.basic;

public class T12_ThreadYieldTest {

	public static void main(String[] args) {
		ThreadYield th1 = new ThreadYield("1번쓰레드");
		ThreadYield th2 = new ThreadYield("2번쓰레드");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(5);
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		th1.work = false; //양보 시작
		
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		th1.work = true; //양보 끝
		
		try {
			Thread.sleep(10);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	
		th1.stop = true;
		th2.stop = true;
	}
}

class ThreadYield extends Thread{
	public boolean stop = false; //반복문을 제어 할 목적으로 만든 변수
	public boolean work = true; //작업 실행을 제어할 목적으로 만든 변수
	
	public ThreadYield(String name) {
		//쓰레드에는 기본적으로 name 속성이 있고, Thread 생성자 중에서는
		//name값을 매개변수로 받아서 설정하는 생성자가 있다.
		super(name); //쓰레드의 이름 설정.
		
	}
	@Override
	public void run() { //stop변수값이 true면 반복을 멈춘다.
		while(!stop) {
			if(work) {
				//작업하는 영역
				
				//getName() => 현재 쓰레드의 name값 반환.
				System.out.println(getName() + "작업중.....");
			}else {
				System.out.println(getName() + "작업양보.....");
				Thread.yield();
			}
		}
	
	System.out.println(getName() + "작업 끝.....");
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	