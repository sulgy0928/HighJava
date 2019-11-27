package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*
 * Comparable and Comparator 예제
 */
public class T07_ListSortTest {

	public static void main(String[] args) {
		List<Member> memList = new ArrayList<>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "변학도", "010-2222-2222"));
		memList.add(new Member(9, "성춘향", "010-3333-3333"));
		memList.add(new Member(3, "이순신", "010-4444-4444"));
		memList.add(new Member(6, "강감찬", "010-5555-5555"));
		memList.add(new Member(2, "일지매", "010-6666-6666"));
		
		System.out.println("정렬 전");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("---------------------------------------------------");
		
		Collections.sort(memList); //정렬하기
		
		System.out.println("이름의 오름차순으로 정렬 후");
		
		for(Member mem: memList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------");
		
		//외부 정렬기준을 이용한 정렬하기.
		Collections.sort(memList, new SortNumDesc());
		
		
		}

}
/*
 * 정렬기준의 외부선은을 위해서는 컴페어러터 인터페이스를 구현하면 된다. 멤버의 번호 num의 내림차순으로 정렬하기
 * 
 */
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
		if(mem1.getNum() > mem2.getNum()) {
			return -1;
		}else if(mem1.getNum() == mem2.getNum()) {
		return 0;
	}else {
		return 1;
	}
	
}
}	
	/*
	 * 회원의 정보를 저장할 클래스
	 * 회원정보는 회원번호, 회원이름, 전화번호로 되어있다.
	 * 회원이름을 기준으로 오름차순 정렬이 될 수 있는 클래스 만들기.
	 */
class Member implements Comparable<Member>{
	private int num;		//번호
	private String name;	//이름
	private String tel;		//전화번호
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	
	

	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	@Override
	public String toString() {
		
		return "Memver[num=" + num + ",name=" + name + ", tel=" + tel + "]";
	}


	/*
	 * 이름을 기준으로 오름차순 정렬이 되도록 설정한다.
	 */
	@Override
	public int compareTo(Member mem) {
		return getName().compareTo(mem.getName());
	}	
}
	
	
	
	
	
	
	
	
	
	

