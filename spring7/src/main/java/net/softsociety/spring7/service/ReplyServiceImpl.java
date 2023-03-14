package net.softsociety.spring7.service;

import net.softsociety.spring7.dao.ReplyDAO;
import net.softsociety.spring7.domain.Board;
import net.softsociety.spring7.domain.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyDAO replyDao;

    /**
     * 댓글 등록
     * @param reply
     * @return
     */
    @Override
    public int writeReply(Reply reply) {
        int result = replyDao.writeReply(reply);
        return result;
    }

    @Override
    public List<Reply> listReply(int boardseq) {
        List<Reply> list = replyDao.listReply(boardseq);

        return list;

    }

    @Override
    public int deleteReply(int replyseq) {
        int result = replyDao.deleteReply(replyseq);
        return result;
    }
}
