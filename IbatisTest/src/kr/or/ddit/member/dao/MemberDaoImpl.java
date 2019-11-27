package kr.or.ddit.member.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao {
	private SqlMapClient smc;
	private static IMemberDao dao;
	
	
	
	private MemberDaoImpl() {
		Reader rd; 
		// 1-1. xml문서 읽어오기
		try{
			Charset charset = Charset.forName("UTF-8"); // 설정파일 인코딩
			Resources.setCharset(charset);
		
			rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			// 1-2. 위에서 읽어온 Reader객체를 이용하여
			//		실제 작업을 진행할 객체 생성
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		
		} catch (IOException e) {
			System.out.println("SqlMapClient 객체생성 실패ㅠㅠ");
			e.printStackTrace();
		}
	}
	
	public static IMemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}
	
	//  사용했던 자원 반납
		private void disConnect() {
		
	
	}
	

	@Override
	public int insertMember(MemberVO mv) {
		
		int cnt = 0;
		
		try {
			Object obj = smc.insert("member.insertMember", mv);
			if(obj == null) {
				cnt = 1;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return cnt;
	}

	@Override
	public boolean getMember(String memId) {
		boolean chk = false;
		
		int cnt = 0;
		
		try {
			cnt = (int) smc.queryForObject("member.getMember", memId);
			
			if(cnt > 0) {
				chk = true;
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
			return chk;
		}
	
		@Override
		public List<MemberVO> getAllMemberList() {
		
			List<MemberVO> memList = new ArrayList<MemberVO>();
			
			try {
				memList = smc.queryForList("member.getMemberAll");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return memList;
		}		
		
	
		@Override
		public int updateMember(MemberVO mv) {
			int cnt = 0;
		
			try {
				cnt = smc.update("member.updateMember", mv);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		
		int cnt = 0;
		
		try {
			cnt = smc.delete("member.deleteMember", memId);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return cnt;
	}

	
	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		List<MemberVO> memList = new ArrayList<>();
		try {
			memList = smc.queryForList("member.getSearchMember", mv);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
			
		return memList;
	}

}

































