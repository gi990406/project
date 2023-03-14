package net.softsociety.spring7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring7.dao.MemberDAO;
import net.softsociety.spring7.domain.Member;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO memberDAO;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    /**
     * 회원가입 처리
     * 암호화 하는 작업
     */
	@Override
	public int insertMember(Member member) {
		String encodedPassword = passwordEncoder.encode(member.getMemberpwd());
		member.setMemberpwd(encodedPassword); // 암호화된 비밀번호를 세팅
		
		int result = memberDAO.insertMember(member);
		return result;
	}

	@Override
	public Member getMemberInfo(String memberid) {
		Member member = memberDAO.getMemberInfo(memberid);
		return member;
	}

	@Override
	public int updateMember(Member member) {
		if (member.getMemberpwd() != null && member.getMemberpwd().length() != 0) {
			String encodedPassword = passwordEncoder.encode(member.getMemberpwd());
			member.setMemberpwd(encodedPassword);
		}

		int result = memberDAO.updateMember(member);
		return result;
	}

	@Override
	public boolean idCheck(String memberid) {
		String result = memberDAO.idCheck(memberid);
		if(result == null ) // 그 아이디가 DB 없다면 : 쓸수 있다.
			return true;
		return false;
	}
}
