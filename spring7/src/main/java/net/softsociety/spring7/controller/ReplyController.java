package net.softsociety.spring7.controller;

import net.softsociety.spring7.domain.Reply;
import net.softsociety.spring7.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReplyController {
    @Autowired
    ReplyService replyService;
    @PostMapping("/reply/replywrite")
    @ResponseBody
    public String replyWrite(Reply reply){
        reply.setMemberid("ki"); // 로그인 후 수정
        int result = replyService.writeReply(reply);

        if (result == 1) {
            return "OK";
        }
        return "Fail";
    }

    @GetMapping("/reply/replylist")
    @ResponseBody
    public List<Reply> replylist(int boardseq) {
        List<Reply> replylist = replyService.listReply(boardseq);

        return replylist;
    }

    @GetMapping("/reply/replydelete")
    @ResponseBody
    public String replydelete(int replyseq) {
        int result = replyService.deleteReply(replyseq);

        if (result == 1) {
            return "OK";
        }
        return "Fail";
    }
}
