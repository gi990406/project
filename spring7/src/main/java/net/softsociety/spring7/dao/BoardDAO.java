package net.softsociety.spring7.dao;

import net.softsociety.spring7.domain.Board;
import net.softsociety.spring7.domain.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardDAO {
    // 글 저장
    public int insertBoard(Board board);

    // 글 한개 읽기
    public Board selectBoard(int boardseq);
    // 1 페이징? (나중에)
    // 글 목록(페이징 없이)
    public List<Board> selectBoardList(Map<String, Object> map);

    // 글 삭제
    public int deleteBoard(int boardseq);

    // 글 수정
    public int updateBoard(Board board);

    // 댓글 저장
    public int insertReply(Reply reply);

    // 댓글 목록
    public List<Reply> selectReplyList(int boardseq);

    // 댓글 삭제
    public int deleteReply(int replyseq);

    // 글 개수 조회
    public int getBoardCount(Map<String, Object> map);

    // 조회수 증가
    public int updateHitcount(int boardseq);
}
