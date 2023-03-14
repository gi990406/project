package net.softsociety.spring7.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring7.domain.Member;
import net.softsociety.spring7.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService service;
    /**
     * join 위한 화면 요청
     * @return
     */
    @GetMapping("/join")
    public String join() {
        return "/member/joinView";
    }

    @PostMapping("/idCheck")
    @ResponseBody
    public String idCheck(String memberid) {
        log.info("전달된 id: {}", memberid);
        boolean result = service.idCheck(memberid);

        if(result)
            return "OK"; // 값이 전달
        return "Fail";
    }
    /**
     * join 위한 화면 요청
     * @return
     */
    @PostMapping("/join")
    public String join(Member member) {
        log.info("회원 데이터 : {}", member.toString());
        // DB에 연동하기
        int result = service.insertMember(member);
        if (result == 1)
            log.info("가입 완료!");

        return "redirect:/";
    }

    /**
     * 로그인 화면 요청
     * @return
     */
    @GetMapping("/loginForm")
    public String loginForm() {
        return "/member/loginForm";
    }
}
