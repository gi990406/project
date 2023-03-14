package net.softsociety.spring3.controller;

import net.softsociety.spring3.domain.Friend;
import net.softsociety.spring3.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ThymeleafController {
    /**
     * model에 여러 종류의 데이터를 담아서 클라이언트에서 처리
     * @param model
     * @return
     */
    @GetMapping("/thymeleaf/thyme1")
    public String thyme1(Model model) {
        String str = "대한민국";
        int num = 23;
        double pi = 3.14159;
        String tag = "<marquee>돌이 굴러가유</marquee>"; // 비표준 태그이므로 사용하지 말 것
        String url = "https://google.com";
        Person p = new Person("전우치", "010-1111-2222");

        model.addAttribute("str", str);
        model.addAttribute("num", num);
        model.addAttribute("pi", pi);
        model.addAttribute("tag", tag);
        model.addAttribute("url", url);
        model.addAttribute("p", p);

        // -----------------------------
        int n1 = 1_230_000; // 천 단위 콤마(,) 대신에 _(under score)로 사용
        double n2 = 5_234.45678;
        double n3 = 123.5;
        Date d = new Date();

        model.addAttribute("inum", n1);
        model.addAttribute("dnum", n2);
        model.addAttribute("dnum2", n3);
        model.addAttribute("date", d);

        model.addAttribute("values", "aaa,bbb,ccc");

        // -----------------
        List<Friend> friendList = new ArrayList<>(); // 다형성
        friendList.add(new Friend("손오공", 23, "010-111-222", true));
        friendList.add(new Friend("저팔계", 24, "010-123-111", true));
        friendList.add(new Friend("사오정", 25, "010-222-223", false));
        friendList.add(new Friend("임꺾정", 26, "010-456-234", true));
        friendList.add(new Friend("전우치", 27, "010-890-567", false));

        model.addAttribute("friendList", friendList);

        return "thymeleaf/thyme1";
    }
}
