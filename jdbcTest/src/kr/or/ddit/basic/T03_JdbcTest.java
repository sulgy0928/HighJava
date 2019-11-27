package kr.or.ddit.basic;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * Insert 예제.
 *
 */
public class T03_JdbcTest {
	/*
	    lprod_id : 101, lprod_gu : N101, lprod_nm : 농산물
	    lprod_id : 102, lprod_gu : N102, lprod_nm : 수산물
	    lprod_id : 103, lprod_gu : N103, lprod_nm : 축산물
	    
	    위의 3줄의 자료를 추가 해 보기.
   
    */
	public static void main(String[] args) {
		 Connection conn = null;
		 Statement stmt = null;
		 PreparedStatement pstmt = null;
		 
		 try {
				// 1. 드라이버 로딩(옵션)
				Class.forName("oracle.jdbc.driver.OracleDriver"); //바로 쓸 수 있게 세팅 잘 돼 있나 확인
				
				// 2. DB 에 접속(Connection 객체 생성)
				
				String url = "jdbc:oracle:thin:@localhost:1521/xe";
				String userId = "PC02";
				String password = "java";
				conn = DriverManager.getConnection(url, userId, password);
				
				stmt = conn.createStatement();
				
				
		/*		String sql = "insert into lprod "
						+ "(lprod_id, lprod_gu, lprod_nm)"
						+ "values (101, 'N101', '농산물')";
				
				//SQL문이 select 문이 아닐 경우 executeUpdate()메서드를 사용한다.
				//executeUpdate()메서드는 실행에 성공한 레코드 수를 반환한다.
				
				int cnt = stmt.executeUpdate(sql);
				System.out.println("첫번쨰 반환값 : " + cnt);
				
				//---------------------------------------------------------------------------------

				sql = "insert into lprod "
						+ "(lprod_id, lprod_gu, lprod_nm)"
						+ "values (102, 'N102', '수산물')";
				
				cnt = stmt.executeUpdate(sql);
				System.out.println("두번쨰 반환값 : " + cnt);
		 
				//---------------------------------------------------------------------------------

				sql = "insert into lprod "
						+ "(lprod_id, lprod_gu, lprod_nm)"
						+ "values (103, 'N104', '축산물')";
				
				cnt = stmt.executeUpdate(sql);
				System.out.println("세번쨰 반환값 : " + cnt);
				
				System.out.println("작업끝.");
		 
		*/
				
		// PreparedStatement 객체를 이용한 자료 추가 방법.
				
		// SQL문 작성.(데이터가 들어갈 자리에 물음표(?) 를 넣는다.)
		String sql = "insert into lprod "
				+ "(lprod_id, lprod_gu, lprod_nm)"
				+ "values(?, ?, ?)"; //3개의 아직 모르는 값을 넣을거라 물음표가 3개.
		
		// PreparedStatement 객체를 생성할 때, SQL 문을 넣어 생성한다.
		pstmt = conn.prepareStatement(sql);
		
		// 쿼리문의 물음표(?)자리에 들어가 데이터를 세팅한다.
		// 형식)) pstmt.set 자료형 이름(물음표 순번, 데이터);
		//		 물음표 순번은 1번부터 시작한다.
		
		pstmt.setInt(1, 101);
		pstmt.setString(2, "N101");
		pstmt.setString(3, "농산물");
		
		// 데이터를 세팅한 후, 쿼리문을 실행한다.
		int cnt = pstmt.executeUpdate();
		System.out.println("첫번째 반환값 : " + cnt);
		//-------------------------------------------------------------------
		
		pstmt.setInt(1, 201);
		pstmt.setString(2, "N201");
		pstmt.setString(3, "수산물");
		
		// 데이터를 세팅한 후, 쿼리문을 실행한다.
		cnt = pstmt.executeUpdate();
		System.out.println("두번째 반환값 : " + cnt);
		//-------------------------------------------------------------------
		pstmt.setInt(1, 301);
		pstmt.setString(2, "N301");
		pstmt.setString(3, "축산물");
		
		// 데이터를 세팅한 후, 쿼리문을 실행한다.
		cnt = pstmt.executeUpdate();
		System.out.println("세번째 반환값 : " + cnt);
		//-------------------------------------------------------------------
		System.out.println("작업 끝.");
		
		
		
	}catch(ClassNotFoundException e) {
		System.out.println("드라이버 로딩 실패");
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		//사용했던 자원 반납
		if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
		if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
		if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	