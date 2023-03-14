package net.softsociety.spring2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class StaticController {
    @GetMapping("/image")
    public String image(){
        // 로그 출력
//        log.info("image 요청 들어옴");
//        System.out.println("/image 요청 들어옴.");
        return "image";
    }

    @GetMapping("/css")
    public String css() {
        return "css";
    }
    @GetMapping("/js")
    public String js() {
        return "js";
    }
}
