package kr.or.ddit.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 
 * ResourceBundle 객체를 이용한 예제.
 *
 */
public class DBUtil3 {
	static ResourceBundle bundle; //ResourceBundle 객체의 변수선언

	static {
			bundle = ResourceBundle.getBundle("db"); //객체생성
			
			try {
				
				Class.forName(bundle.getString("driver"));
				
			}catch(ClassNotFoundException e) {
				System.out.println("드라이버 로딩 실패ㅠㅠ");
	}
}	
public static Connection getConnection() {
	try {
		return DriverManager.getConnection(
				bundle.getString("url"),
				bundle.getString("user"),
				bundle.getString("pass"));
				
				
	}catch(SQLException e) {
		System.out.println("DB연결 실패ㅠㅠ");
		e.printStackTrace();
		return null;
		}
	}
}
