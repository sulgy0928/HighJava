package kr.or.ddit.basic;
/**
 * 
 * 애너테이션 사용 예제
 *
 */
public class Service {

	@PrintAnnotation()
	public void method1() {
		System.out.println("메서드1에서 출력되었습니다.");
	}
	@PrintAnnotation("%") //value하나만쓰는경우는 밑처럼 쓰지 않아도 됨. 
	public void method2() {
		System.out.println("메서드2에서 출력되었습니다.");
	}
	@PrintAnnotation(value = "#", count = 25) // 하지만 이렇게 할 경우는 value 단어 생략 안됨.
	public void method3() {
		System.out.println("메서드3에서 출력되었습니다.");
	}


}
