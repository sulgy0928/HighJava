package kr.or.ddit.basic;
/**
 * 싱글쓰레드 프로그램
 * @author pc08
 *
 */
public class T01_ThreadTest {
	public static void main(String[] args) {
		
		for(int i=1; i<=200; i++) {
			System.out.println("*");
		}
	System.out.println();
	
	for(int i=1; i<=200; i++) {
		System.out.println("&");
	}
	}
}

