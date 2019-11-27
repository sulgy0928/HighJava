package kr.or.ddit.basic;
/*
  제너릭 클래스를 만드는 방법
 	형식))
  		class 클래스명<제너릭타입글자>{
 			제너릭타입글자 변수명;   //변수 선언에 제너릭을 사용 할 경우.
  			...
 
  			제너릭타입글자 메서드명(){ //반환값이 있는 메서드에서 사용
  			...
  			
  			return 값;
  
 
 
  		}
  		...
  	}
 
	 -- 제너릭 타입 글자 --
	 	
	 	T => Type
	 	K => Key
	 	V => Value
	 	E => Element(자료구조에 들어가는 것들을 나타낼 때 사용.)
 	
 */
class NonGenericClass{ //제너릭을 적용하지 않은 예의 클래스
	private Object val;
	
	public Object getVal() {
		return val;
	}
	public void setVal(Object val) {
		this.val = val;
	}
}

class MyGeneric<T>{  //제너릭문법을 이용한 선언. 꺽쇠가 없으면 제너릭 아님.ㅋ
						//특정한 타입만 제한하기때문에 안전함.(type safe)
		private T val;

		public T getVal() {
			return val;
		}

		public void setVal(T val) {
			this.val = val;
	}
		
}
	
public class T03_GenericTest {
	public static void main(String[] args) { //모든타입을 오브젝트로 넣어야해서 꺼내쓸때도 오브젝트타입으로 꺼내야함. 
												//아래와 같이 형변환해서 String으로 지정해두면 나중에 String으로 꺼내 쓸 수 있다.
		
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setVal("가나다라");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);
		
		String rtnNg1 = (String)ng1.getVal();
		System.out.println("문자열 반환값 rtnNg1 => " + rtnNg1);
		
		Integer irtnNg2 = (Integer) ng2.getVal();
		System.out.println("정수 반환값 irtnNg2 => " + irtnNg2);
		
		MyGeneric<String> mg1 = new MyGeneric<String>(); //위에서 <T>로만 써줬는데 그래도 상관없지만 컴파일 전엔 정확히 적어줘야함.
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		
		mg1.setVal("우리나라"); //type safe code가 됐기떄문에 지정한 타입이 아니면 올 수 없다. 바로 컴파일에러
		mg2.setVal(500);
		
		rtnNg1 = mg1.getVal(); //제너릭이라 여기서 일일이 형변환해주지않아도돼서 훨 간결한 코드가 된다.
		irtnNg2 = mg2.getVal();
	
		System.out.println("제너릭 문자열 반환값 : " + rtnNg1);
		System.out.println("제너릭 문자열 반환값 : " + irtnNg2);
	
	
	}
	
}
























