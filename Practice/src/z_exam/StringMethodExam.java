package z_exam;

public class StringMethodExam {

	public static void main(String[] args) {
			
//		String str = new String("hello");
//		String str = "hello";
//		System.out.println(str.length()); //문자열 길이 구해서 반환해줌
//		System.out.println(str.concat("world"));
//		System.out.println(str);
//		//String 은 참조형이라 한번 만들어진 객체를 바꾸지않는다. (불변클래스)라고 함.
//		str = str.concat(" world");
//		System.out.println(str);
//		
//		System.out.println(str.substring(3));
//		System.out.println(str.substring(3, 7));
		
		String str1 = "안녕하세요. ";
        String str2 = "벌써 여기까지 오셨네요. 끝까지 화이팅!!";
        
        String concatResult;
        String substringResult;
        
        // 아래쪽에 코드를 작성하세요.
        concatResult = (str1.concat(str2));
        
        substringResult = (str1.substring(2));
        
        
        
        // 이 아래는 정답 확인을 위한 코드입니다. 수정하지 마세요.
        System.out.println(concatResult);
        System.out.println(substringResult);
	}
}




























