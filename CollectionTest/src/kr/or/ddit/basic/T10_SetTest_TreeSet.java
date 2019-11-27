package kr.or.ddit.basic;

import java.util.SortedSet;
import java.util.TreeSet;

/*
 * Tree Set 예제
 */
public class T10_SetTest_TreeSet {

	public static void main(String[] args) {
		// HashSet은 데이터에 순서가 없으나(등록되는 순서를 모름)
		// TreeSet은 자동정렬기능이있다.

		TreeSet<String> ts = new TreeSet<>();
		
		//영어 대분자를 문자열로 변환하여 TreeSet에 저장.
		for(char ch = 'Z'; ch >= 'A'; ch--) { //거꾸로 넣어도 정렬이 되는지 보여주는 예로 굳이 거꾸로 만들어 본 것.
			String temp = String.valueOf(ch);
			ts.add(temp);
		}
		System.out.println("TreeSet 자료 : " + ts);
		
		//TreeSet 에 저장된 자료 중 특정한 자료보다 작은 자료를 찾아서
		//SortedSet 으로 변환하는 메서드가 있다.
		// => headSet(기준값)메서드 (기본적으로 '기준값'은 포함시키지 않는다.)
		// => headSet(기준값, 논리값) (논리값이 true 이면 '기준값'을 포함)
		
		SortedSet<String> ss1 = ts.headSet("K"); //이 값을 기준으로 머리값 가져오라는 코드
		System.out.println("K 이전의 자료 : " + ss1); //기준값 미포함
		System.out.println("K 이전 자료(기준값 포함): " + ts.headSet("K", true));//기준값 포함.
		
		
		// '기준값' 보다 큰 자료를 찾아 SortedSet으로 반환하는 메서드.
		// tailSet(기준값)  => 기본적으로 '기준값' 을 포함시킨다.
		// tailSet(기준값, 논리값)  => 논리값이 false이면 '기준값'을 포함하지 않음.		
		
		SortedSet<String> ss2 = ts.tailSet("K"); //기준점 이후의 꼬리값.
		System.out.println("K 이후 자료 : " + ss2); //기준값 포함
		System.out.println("K 이후 자료(기준값 미포함) : " + ts.tailSet("K" , false));//기준값 미포함
		
		//subSet(기준값1, 기준값2)   =>   기준값 1 ~ 기준값1 사이의 값을 가져온다.
		//								('기준값1' 포함, '기준값2' 미포함)
	
		//subSetI(기준값1, 논리값1, 기준값2, 논리값2  => 각 기준값을 포함할지 여부 설정함.
		//											(논리값이 true면 포함, false면 미포함.)
		
		System.out.println("K(포함)부어 N(미포함)까지 : " + ts.subSet("K",true, "N", true));
		
		System.out.println("K(포함)부어 N(미포함)까지 : " + ts.subSet("K", "N"));
		System.out.println("K(포함)부어 N(미포함)까지 : " + ts.subSet("K",false, "N", false));
		System.out.println("K(포함)부어 N(미포함)까지 : " + ts.subSet("K",false, "N", true));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
