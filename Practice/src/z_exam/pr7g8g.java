package z_exam;

public class pr7g8g {
	
		public static void main(String[] args) {
			String str1 = "hello";
			String str2 = "hello";
			
			String str3 = new String("hello");
			String str4 = new String("hello");
			
			if(str1 == str2)
				System.out.println("str1과 str2는 같은 레퍼런스.");
			if(str1 == str3)
				System.out.println("str1 str3?");
			if(str3 == str4)
				System.out.println("str1 str3?");
			
//			String객체는 한번 생성하면 바뀌지않음.(다른건안그러는데 스트링만 좀 특이)
			
//			System.out.println(str1);
//			System.out.println(str1.substring(3));
//			System.out.println(str1);
			
			if(str1.equals(str2)) {
				System.out.println("str1과 2는 같다.");
			}else {
				System.out.println("str1과 2는 다르다..");
			}
		}
}



	