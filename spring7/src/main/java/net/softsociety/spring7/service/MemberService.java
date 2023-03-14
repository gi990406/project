package net.softsociety.spring7.service;

import net.softsociety.spring7.domain.Member;


public interface MemberService {
	/**
	 * 회원가입
	 */
	public int insertMember(Member member);
	
	/**
	 * 회원 검색
	 * @param memberid
	 * @return
	 */
	public Member getMemberInfo(String memberid);
	
	
	/**
	 * 회원정보 수정
	 * @param member
	 * @return
	 */
	public int updateMember(Member member);
	
	/**
	 * 회원 가입 시 중복된 아이디의 여부 확인 
	 * @param memberid
	 * @return
	 */
	public boolean idCheck(String memberid);
	
}
