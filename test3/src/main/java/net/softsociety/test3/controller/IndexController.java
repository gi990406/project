package net.softsociety.test3.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.test3.domain.Fitness;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }
        @PostMapping ("/mybmi")
        public String mybmi(Fitness fitness, Model model) {
            double height = fitness.getHeight() * 0.01; // 지역 변수

            double bmi = fitness.getWeight() / (height * height);
            fitness.setBmi(bmi);

            log.info("결과 : {}", fitness.toString());

            model.addAttribute( "bmi", bmi);

            return "result";
    }

}
