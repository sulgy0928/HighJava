package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여
 * service에 전달하는 DAO의 interface 
 * 
 * @author pc08
 *
 */
public interface IMemberDao {
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메서드.
	 * @param mv DB에 insert 할 자료가 저장된 MemberVO객체
	 * @return DB작업이 성공하면 1 이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int insertMember(MemberVO mv);
	
	/**
	 * 주어진 회원ID 가 존재하는지 여부를 알아내는 메서드.
	 * @param memId 검색할 회원 ID
	 * @return 해당 회원 ID가 있으면 true, 없으면 false를 반환한다.
	 * 
	 */
	public boolean getMember(String memId);
	
	/**
	 * DB의 mymember 테이블의 전체 레코드를 가져와서 List에 담아 반환하는 메서드
	 * @return MemberVO 객체를 담고있는 List 객체
	 */
	public List<MemberVO> getAllMemberList();
	

	/**
	 * 하나의 MemberVO 자료를 이용하여 DB 를 update 하는 메서드.
	 * @param mv  update 할 회원정보가 들어있는 MemberVO객체
	 * @return  작업성공 : 1, 작업실패 : 0
	 * 
	 */
	public int updateMember(MemberVO mv);
	
	/**
	 * 회원 ID를 매개변수로 받아서 그 회원정보를 삭제하는 메서드.
	 * @param memId 삭제할 회원 ID
	 * @return  작업성공 : 1, 작업실패 : 0
	 */
	public int deleteMember(String memId);
	
	
	/**
	 * MemberVO에 담긴 자료를 이용하여 회원을 검색하는 메서드
	 * 
	 * @param mv 검색할 자료가 들어있는 MemberVO 객체
	 * @return  검색된 결과를 담은 List
	 * 
	 */
	public List<MemberVO> getSearchMember(MemberVO mv);
}

































