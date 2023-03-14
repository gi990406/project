package net.softsociety.test2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FavoriteController {
    @GetMapping("/hobby")
    public String hobby() {
        return "hobby";
    }

    @GetMapping("/song")
    public String song() {
        return "song";
    }
}
