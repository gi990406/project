package net.softsociety.spring3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/cookie")
public class CookieController {
    @GetMapping("/cookieSave")
    public String cookieSave(HttpServletResponse response) {
        // 쿠키 객체 생성
        Cookie cook1 = new Cookie("usrname", "홍길동");
        Cookie cook2 = new Cookie("phone", "010-1111-2222");
        
        // 쿠키의 정보(종료기간: 초 단위) 지정
        cook1.setMaxAge(24*60*60); // 정보가 하루동안(24시간x60분x60초) 저장
        cook2.setMaxAge(24*60*60);

        response.addCookie(cook1);
        response.addCookie(cook2);

        System.out.println("쿠키가 저장됨.");

        return "redirect:/";
    }

    /**
     * 저장된 쿠키 읽기 (클라이언트에서 보낸 쿠키)
     * @return
     */
    @GetMapping("/cookieRead")
    public String cookieRead(
            @CookieValue(name="usrname", defaultValue = "없음") String usrname,
            @CookieValue(name="phone", defaultValue = "0") String phone
    ) {

        System.out.println("저장된 쿠키값(이름): " + usrname);
        System.out.println("저장된 쿠키값(번호): " + phone);

        return "redirect:/";
    }

    /**
     * 쿠키 삭제
     * @return
     */
    @GetMapping("/cookieDelete")
    public String cookieDelete(HttpServletResponse response){
        // 이전에 저장한 쿠키와 같은 이름의 쿠키를 생성
        Cookie cook1 = new Cookie("usrname", null);
        Cookie cook2 = new Cookie("phone", null);

        // 쿠키 수명을 0으로
        cook1.setMaxAge(0);
        cook2.setMaxAge(0);

        // 쿠키를 클라이언트로 보냄
        response.addCookie(cook1);
        response.addCookie(cook2);

        System.out.println("쿠키 정보 삭제됨");
        return "redirect:/";
    }
}
