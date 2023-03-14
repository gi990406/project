package net.softsociety.blog.service;

import net.softsociety.blog.dao.MemberDAO;
import net.softsociety.blog.domain.Member;

import java.util.List;
import java.util.Map;

public interface MemberService {
    /**
     * 회원가입
     */
    public int insertMember(Member member);

    /**
     * 회원 검색
     * @param blogid
     * @return
     */
    public Member getMemberInfo(String blogid);

    public List<Member> list(String blogid, String blogername, String photo);


}
