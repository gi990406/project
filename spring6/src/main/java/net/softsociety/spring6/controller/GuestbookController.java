package net.softsociety.spring6.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring6.domain.Guestbook;
import net.softsociety.spring6.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class GuestbookController {
    @Autowired
    GuestbookService service;
    /**
     * 방명록 등록을 위한 화면 요청
     * @return
     */
    @GetMapping("/regist")
    public String regist() {
        return "regist";
    }

    /**
     * 방명록 등록 처리 요청
     * @param guestbook
     * @return
     */
    @PostMapping("/regist")
    public String regist(Guestbook guestbook) {
        log.info("글쓴이 : {}, 글 내용: {}", guestbook.getWriter(), guestbook.getText());

        int result = service.insertGuestbook(guestbook);

        return "redirect:/";
    }

    /**
     * DB에 등록된 전체 방명록 조회 요청
     * @return
     */
    @GetMapping("/retrieve")
    public String retrieve(
            @RequestParam(name="seq", defaultValue = "0") int seq,
            @RequestParam(name="writer", defaultValue = "") String writer,
            @RequestParam(name="text", defaultValue = "") String text,
            Model model) {
        List<Guestbook> list = service.selectAll();

        model.addAttribute("list", list);
        model.addAttribute("seq", seq);
        model.addAttribute("writer", writer);
        model.addAttribute("text", text);

        return "/retrieve";
    }

    @GetMapping("/delete")
    public String delete(int seq) {
        log.info("삭제 번호: {}", seq);
        service.delete(seq);
        return "redirect:/retrieve"; // GET
    }

    /**
     * 업데이트를 위해 글 하나를 조회
     * @param seq
     * @return
     */
    @GetMapping("/update")
    public String update(int seq, RedirectAttributes rttr) {
        log.info("조회 번호: {}", seq);

        Guestbook guestbook = service.selectOne(seq); // seq, writer, text

        rttr.addAttribute("seq", guestbook.getSeq());
        rttr.addAttribute("writer", guestbook.getWriter());
        rttr.addAttribute("text", guestbook.getText());

        return "redirect:/retrieve";
        // index, delete ==> 파라미터가 없음.
        // update ==> 파라미터 있음.

    }

    @PostMapping("/update")
    public String update(int seq, Guestbook guestbook) {

        log.info("글쓴이 : {}, 글 내용: {}", guestbook.getWriter(), guestbook.getText());

        int result = service.updateGuestbook(guestbook);

        return "redirect:/retrieve";
    }
}
