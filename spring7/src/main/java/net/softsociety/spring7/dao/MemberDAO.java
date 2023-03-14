package net.softsociety.spring7.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring7.domain.Member;

@Mapper
public interface MemberDAO {
	
	/**
	 * 아이디 중복확인
	 * @param memberid
	 * @return
	 */
	public String idCheck(String memberid);

	/**
	 * 회원의 정보를 DB에 저장 ==> 회원가입 처리
	 * @param member
	 * @return
	 */
	public int insertMember(Member member);
	
	/**
	 * 한 명의 회원정보를 가져오는 메소드
	 * @param memberid
	 * @return
	 */
	public Member getMemberInfo(String memberid);
	
	
	/**
	 * 회원의 정보를 수정하는 메소드
	 * @param member
	 * @return
	 */
	public int updateMember(Member member);
	
}








