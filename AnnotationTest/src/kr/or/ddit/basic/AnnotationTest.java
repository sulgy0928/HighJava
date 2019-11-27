package kr.or.ddit.basic;import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {

	public static void main(String[] args) throws  Exception {
		System.out.println(PrintAnnotation.id);
		
		// reflection 기능을 이용한 메서드 실행
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		
		for(Method m : declaredMethods) {
			System.out.println(m.getName()); // 메서드명 출력
			for(int i = 0;
					i < m.getDeclaredAnnotation(PrintAnnotation.class)
					.count(); i++) { // PrintAnnotation의 count 만큼..
				System.out.print(m.getDeclaredAnnotation(PrintAnnotation.class).value());
				
			}
			System.out.println(); //줄바꿈처리
			
			m.invoke(new Service()); // reflection 기능을 이용한 메서드 실행
		}

	}

}
