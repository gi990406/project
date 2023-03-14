package net.softsociety.spring3.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring3.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/param")
public class ParamController {

    // param/input1?name=James&age=28
    // 1) a 태그로 전송된 데이터 출력
    // 2) a 태그로 데이터가 넘어오지 않는 경우 - 초기값으로 만들고 사용할 수 있다.
    @GetMapping("/input1")
    public String input1(@RequestParam(name="name", defaultValue = "아무개") String name,
                         @RequestParam(name="age", defaultValue = "0") int age) {
        log.info("전송된 데이터 : 이름 {}, 나이 {}",name, age);
        System.out.printf("전송된 데이터 : 이름 %s, 나이 %d%n", name, age);
        return "redirect:/"; // 폴더명 param, 파일명 view1.html
    }

    // 폼 화면을 요청
    @GetMapping("/view1")
    public String view1() {
        return "/param/view1"; // 폴더명 param, 파일명 views.html
    }

    @GetMapping("/input2")
    public String input2(Member member) {
        log.info("이름 {}", member.getUsrname());
        return "redirect:/";
        }
}
