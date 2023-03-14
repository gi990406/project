package net.softsociety.spring7.dao;

import net.softsociety.spring7.domain.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyDAO {
    /**
     * 댓글 등록
     * @param reply
     * @return
     */
    public int writeReply(Reply reply);

    /**
     * 지정된 메인글에 대한 댓글 목록 반환
     * @param boardseq
     * @return
     */
    public List<Reply> listReply(int boardseq);

    /**
     * 댓글 삭제
     * @param replyseq
     * @return
     */
    public int deleteReply(int replyseq);
}
