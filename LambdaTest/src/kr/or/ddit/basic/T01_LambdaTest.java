package kr.or.ddit.basic;

/*
 		람다식 => 익명함수를 생성하기 위한 식.
 				 자바에서는 '매개변수를 가진 코드 블럭'
 				 => 런타임 시, 익명구현객체로 생성된다.
 				 
 		형식)) 인터페이스명 객체변수명 = 람다식;
 		
 		람다식의 형식)) (매개변수들) -> {처리할 코드들;}
 		
 		=> 람다식으로 변환 할 수 있는 인터페이스는 추상메서드가 1개인
 		    인터페이스만 변환 할 수 있다.
 		    이런 인터페이스를 '함수적 인터페이스' 라고 한다.
 		    이 함수적 인터페이스를 만들 땐 @FunctionalInterface 로 지정한다.
 		    
 */
public class T01_LambdaTest {

	public static void main(String[] args) {
		// 람다식을 사용하지 않는 경우.
		Thread th1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1; i<=10; i++) {
					System.out.println(i);
				}
			}
			
		});
		th1.start();
		
		// 람다식을 쓰는 경우.
		Thread th2 = new Thread(()-> {
			for(int i=1; i<=10; i++) {
				System.out.println("람다 - " + i);
			}
		});
	
		
/*
 		람다식 작성법
 		기본형식)) (자료형이름 매개변수명,..) -> {실행문들;..}
 		
 		1)매개변수의 '자료형 이름'은 생략 할 수 있다.
 			예) (int a) -> {System.out.println(a);}
 				 (a) -> {System.out.println(a);}
 				 
 		2) 매개변수가 1개일 경우, 괄호'()'를 생략 할 수 있다.
 		(단, '자료형이름' 을 지정 할 경우, 괄호를 생략 할 수 없다.)
 		
 			예) a -> {System.out.println(a);}
 		
 		3) '실행문'이 1개일 경우 '{}' 를 생략 할 수 있다.
 		(이때 문장의 끝을 나타내는 세미킬론(;)도 생략한다.)
 		
 			예) a -> System.out.println(a)
 		
 		4) 매개변수가 하나도 없으면 괄호'()'를 생략 할 수 없다.
 		
 			예) () -> a -> System.out.println("안녕")
 		
 		
 		5) 반환값이 있을 경우, return 명령을 사용한다.
 		
	 		예) (a,b) -> { return a + b; }
	 		    (a,b) ->   return  a + b
 			
 			
 		6) 실행문에 return 문만 있을 경우, return 명령과 '{}'를 생략 할 수 있다.
 		
 			예) (a,b)  ->  (a + b)
 */
	}

}





























