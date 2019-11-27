package kr.or.ddit.basic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;

/*
	회원정보를 관리하는 프로그램을 작성하는데 
	아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
	(DB의 MYMEMBER테이블을 이용하여 작업한다.)
	
	* 자료 삭제는 회원ID를 입력 받아서 삭제한다.
	
	예시메뉴)
	----------------------
		== 작업 선택 ==
		1. 자료 입력			---> insert
		2. 자료 삭제			---> delete
		3. 자료 수정			---> update
		4. 전체 자료 출력	---> select
		5. 작업 끝.
	----------------------
	 
	   
// 회원관리 프로그램 테이블 생성 스크립트 
create table mymember(
    mem_id varchar2(8) not null,  -- 회원ID
    mem_name varchar2(100) not null, -- 이름
    mem_tel varchar2(50) not null, -- 전화번호
    mem_addr varchar2(128)    -- 주소
);

*/
public class T05_MemberInfoTest {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in); 
	
	// Log4j를 이용한 로그 남기기.
	private static final Logger sqlLogger = Logger.getLogger("log4jexam.sql.Query");
	private static final Logger paramLogger = Logger.getLogger("log4jexam.sql.Parameter");
	private static final Logger resultLogger = Logger.getLogger(T05_MemberInfoTest.class);
	
	
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	public void start(){
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 자료 입력
						insertMember();
			
					break;
				case 2 :  // 자료 삭제
						deletMember();
				
					break;
				case 3 :  // 자료 수정
						updateMember();
				
					break;
				case 4 :  // 전체 자료 출력
						displayMemberAll();
					break;
				case 5 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=5);
	}
	
	
	/**
	 * 회원정보를 삭제하는 메서드deletMember(); (입력받은 회원ID를 이용하여 삭제한다.)
	 */
	private void deletMember() {
			System.out.println();
			System.out.println("삭제할 회원 ID >>");
			String memId = scan.next();
			
			try {
				conn = DBUtil.getConnection();
				String sql = "delete from mymember where mem_id = ? ";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memId);
				
				int cnt = pstmt.executeUpdate();
				if(cnt > 0) {
					System.out.println(memId + "회원 삭제 성공.");
				}else {
					System.out.println(memId + "회원삭제실패ㅠㅠ");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				disConnect();
			}
	}

	/**
	 * 전체 회원을 출력하는 메서드 updateMember();
	 */
	private void updateMember() {
			System.out.println();
			String memId = "";
			boolean chk = true;
			
			do {
				System.out.println("수정할 회원 ID를 입력하세요. >>");
				memId = scan.next();
				
				chk = getMember(memId);
				if(chk == false) {
					System.out.println(memId + "회원은 없는회원입니다.");
					System.out.println("수정할 자료가 없습니다. 다시 입력 해 주세요.");
				}
			}while(chk == false);
			
			System.out.println("수정할 내용을 입력하세요.");
			System.out.print("새로운 회원 이름 >> ");
			String memName = scan.next();
			
			System.out.print("새로운 회원 전화번호 >> ");
			String memTel = scan.next();
			
			scan.nextLine();
			System.out.println("새로운 회원 주소 >>");
			String memAddr = scan.nextLine();
			
			try {
				//conn = DBUtil.getConnection();
				conn = DBUtil2.getConnection();
				
				String sql = "update mymember"
							+ " set mem_name = ?,"
							+ " mem_Tel = ?"
							+ "		, mem_addr = ?"
							+ " where mem_id = ?";
				
				
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memName);
				pstmt.setString(2, memTel);
				pstmt.setString(3, memAddr);
				pstmt.setString(4, memId);
				
				
												
				int cnt = pstmt.executeUpdate();
				
				
				
				if(cnt > 0) {
					System.out.println(memId + "회원정보 수정 완료.");
				}else {
					System.out.println(memId + "정보수정실패ㅠㅠ");
				}
			
			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				disConnect();
			}
		}

	/**
	 * 전체회원을 출력하는 메서드 displayMemberAll();
	 */
	
	private void displayMemberAll() {
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println(" ID\t이름\t전화번호\t주 소");
		System.out.println("---------------------------------");
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from mymember";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				
				System.out.println(memId + "\t" 
									+ memName + "\t"  
									+ memTel + "\t"  
									+ memAddr + "\t");  
			}
			System.out.println("------------------------------------------------");
		
			System.out.println("출력작업 끝.");
			
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
	}

	/**
	 * 
	 * 회원을 추가하는 메서드insertMember();
	 * 
	 */
	public void insertMember() {
		boolean chk = false;
		
		String memId;
		
		do {
			System.out.println();
			System.out.println("추가할 회원 정보를 입력하세요.");
			System.out.println("회원 ID >>");
			memId = scan.next();
			chk = getMember(memId);
			if(chk) {
				System.out.println("회원ID가 " + memId + " 이미 존재하는 회원입니다.");
				System.out.println("다시입력하세요.");
			}
			
		}while(chk);
		
		System.out.println("회원이름 >> ");
		String memName = scan.next();

		System.out.println("회원 전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine(); // 입력버퍼 비우기.
		
		System.out.println("회원주소 >>");
		String memAddr = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "insert into mymember"
					+ "(mem_id, mem_name, mem_tel, mem_addr)"
					+ "values (?,?,?,?) ";
			sqlLogger.debug("쿼리 : " + sql);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);
					
			paramLogger.debug("파라미터 : " + "(" 
					  + memId + ","
					  + memName + ","
					  + memTel + ","
					  + memAddr + ")");
			
			int cnt = pstmt.executeUpdate();
			resultLogger.debug("결과 : " + cnt);
			
			if(cnt > 0) {
				
				System.out.println(memId + "회원 추가작업 성공");
			}else {
				System.out.println(memId + "회원추가실패ㅠㅠ");
			}
		}catch(SQLException e) {
			System.out.println(memId + "회원추가실패ㅠㅠ");
			e.printStackTrace();
		}finally{
			disConnect();
		}
	
	//  사용했던 자원 반납
		if(rs!=null)try{ rs.close(); }catch(SQLException e){}
		if(pstmt!=null)try{ pstmt.close(); }catch(SQLException e){}
		if(stmt!=null)try{ stmt.close(); }catch(SQLException e){}
		if(conn!=null)try{ conn.close(); }catch(SQLException e){}
	
	}
	
	private void disConnect() {
		// TODO Auto-generated method stub
		
	}
/**
 * 회원ID로 회원 중복을 체크하는 메서드 getMember.
 * @param memId
 * @return
 */
	private boolean getMember(String memId) {
		boolean chk = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select count(*) cnt from mymember "
						+ " where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		if(cnt > 0) {
			chk = true;
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		disConnect();
	}
		
		
		return chk;
	}

	public static void main(String[] args) {
		T05_MemberInfoTest memObj = new T05_MemberInfoTest();
		memObj.start();
	}

}



































