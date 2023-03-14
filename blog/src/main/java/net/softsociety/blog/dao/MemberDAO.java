package net.softsociety.blog.dao;

import net.softsociety.blog.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface MemberDAO {
    /**
     * 회원의 정보를 DB에 저장 ==> 회원가입 처리
     * @param member
     * @return
     */
    public int insertMember(Member member);

    /**
     * 한 명의 회원정보를 가져오는 메소드
     * @param blogid
     * @return
     */
    public Member getMemberInfo(String blogid);
    public List<Member> selectMemberList(Map<String, Object> map);


}
