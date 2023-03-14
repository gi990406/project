package net.softsociety.spring4.controller;

import net.softsociety.spring4.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    /**
     * 회원가입을 위한 화면 요청
     * @return
     */
    @GetMapping("member/joinForm") // 사용자가 폴더가 있는 것처럼...
    public String joinForm(){
        return "member/joinForm"; // 진짜 폴더+파일명 필요
    }

    /**
     * 회원가입 처리 요청
     * @param member
     * @return
     */
    @PostMapping("member/join")
    public String join(Member member) {
        System.out.println(member);
        return "redirect:/";
    }

    /**
     * 로그인을 위한 화면 요청
     * @return
     */
    @GetMapping("member/loginForm")
    public String loginForm() {
        return "member/loginForm";
    }

    @PostMapping("member/login")
    public String login(Member member, HttpSession session){
        System.out.println(member); // aaa / aaaa / 홍길동
        // DB에 확인 작업을 했다고 치고...
        // Session 작업을 이용해 로그인한 회원이 정보를 저장
        session.setAttribute("loginID", member.getUsrid());
        session.setAttribute("usrname", "홍길동");

        return "redirect:/"; // 로그인이 완료된 경우 결과를 화면에 보여주기 위한 것
    }

    /**
     * 로그아웃 처리 요청: 세션에 저장된 정보 삭제
     * @return
     */
    @GetMapping("member/logout") 
    public String logout(HttpSession session) {
        // 세션 정보 삭제
        session.removeAttribute("loginID");
        session.removeAttribute("usrname");

        // 한번에 삭제
//        session.invalidate();

        return "redirect:/";
    }
}
