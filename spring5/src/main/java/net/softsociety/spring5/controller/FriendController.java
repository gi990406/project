package net.softsociety.spring5.controller;

import net.softsociety.spring5.domain.Friend;
import net.softsociety.spring5.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FriendController {
    @Autowired
    FriendService service;

    /**
     * 데이터 입력을 위한 화면 요청
     * @return
     */
    @GetMapping("/insert")
    public String insert() {
        return "insertForm";
    }

    /**
     * 입력된 데이터를 저장
     */
    @PostMapping("insert")
    public String insert(Friend friend) {
        System.out.println(friend);

        int result = service.insertFriend(friend);
        if(result == 1) {
            System.out.println("저장됨");
            
        } else {
            System.out.println("저장실패");
        }

        return "redirect:/";
    }

    /**
     * 입력된 전체 데이터의 조회 후 출력을 요청
     * @return
     */
    @GetMapping("/select")
    public String select(Model model){
        List<Friend> list = service.selectAll();

        model.addAttribute("list", list);
        
        return "list";
    }
}

// 메소드 오버로딩: 메소드명은 같고, 전달인자의 타입이나 개수가 다르면 다른 메소드로 인식
// 메소드 오버라이딩: 상속받은 메소드를 하위 클래스에서 내용을 변경해서 사용
