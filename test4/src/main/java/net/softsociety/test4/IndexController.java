package net.softsociety.test4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("/calc")
    public String calc(double x, double y, String oper, Model model) {

        double result = 0; // 결과 저장 변수

        double x1 = 0, y1 = 0; // "34.1"

        try {
            x1 = Double.parseDouble(String.valueOf(x)); // "34#1"
            y1 = Double.parseDouble(String.valueOf(y));

        switch(oper) {
            case "+":
                result = x1 + y1;
                break;
            case "-":
                result = x1 - y1;
                break;
            case "*":
                result = x1 * y1;
                break;
            case "/":
                result = x1 / y1;
                break;
        }

        model.addAttribute("result", result);
    } catch (Exception e) {
        e.printStackTrace();
        return "error"; // 에러 페이지
        }
        return "index";
    }
}
