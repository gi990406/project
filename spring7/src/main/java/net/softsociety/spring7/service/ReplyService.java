package net.softsociety.spring7.service;

import net.softsociety.spring7.domain.Reply;

import java.util.List;

public interface ReplyService {
    // 댓글 저장
    public int writeReply(Reply reply);

    // 댓글 목록
    public List<Reply> listReply(int boardseq);

    // 댓글 삭제
    public int deleteReply(int replyseq);

}
