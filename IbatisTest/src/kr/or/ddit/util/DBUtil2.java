package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * db.properties 파일의 내용으로 DB정보를 설정하기
 *
 */
public class DBUtil2 {
	static Properties prop; //Properties 객체변수 선언
	
	static { //위의 클래스 읽어들일 때 사용하는 static 초기화블럭.
		prop = new Properties(); //객체생성
		
		File file = new File("res/db.properties");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			
			Class.forName(prop.getProperty("driver"));
			
		}catch(IOException e) {
			System.out.println("파일이 없거나 입출력오류입니다.");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패ㅠㅠ");
			
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("uger"),
					prop.getProperty("pass"));
					
					
		}catch(SQLException e) {
			System.out.println("DB연결 실패ㅠㅠ");
			e.printStackTrace();
			return null;
		}
	}
}
