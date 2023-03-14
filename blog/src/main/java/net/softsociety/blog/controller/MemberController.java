package net.softsociety.blog.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.blog.domain.Member;
import net.softsociety.blog.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService service;

    /**
     * 회원가입 화면 요청
     * @return
     */
    @GetMapping("/join")
    public String join() {
        return "/member/joinView";
    }

    /**
     * 회원가입 요청 처리
     * @param member
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

    @GetMapping("/memberlist")
    public String memberlist(
            @RequestParam(value = "blogid", defaultValue = "") String blogid,
            @RequestParam(value = "blogername", defaultValue = "") String blogername,
            @RequestParam(value = "photo", defaultValue = "") String photo,
            Model model) {

        // 게시글 목록을 DB로부터 요청하는 문장 필요
        List<Member> list = service.list(blogid, blogername, photo);

        model.addAttribute("blogid", blogid);
        model.addAttribute("blogername", blogername);
        model.addAttribute("photo", photo);
        model.addAttribute("list", list);

        return "/member/memberlist";
    }
}
