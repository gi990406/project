package net.softsociety.blog.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.blog.dao.MemberDAO;
import net.softsociety.blog.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDAO memberDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int insertMember(Member member) {
        String encodedPassword = passwordEncoder.encode(member.getBlogpwd());
        member.setBlogpwd(encodedPassword); // 암호화된 비밀번호를 세팅

        int result = memberDAO.insertMember(member);
        return result;
    }

    @Override
    public Member getMemberInfo(String blogid) {
        Member member = memberDAO.getMemberInfo(blogid);
        return member;
    }

    @Override
    public List<Member> list(String blogid, String blogername, String photo) {
        Map<String, Object> map = new HashMap<>();

        List<Member> list = memberDAO.selectMemberList(map);

        return list;
    }

}

