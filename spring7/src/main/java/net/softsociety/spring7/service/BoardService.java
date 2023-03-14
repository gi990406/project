package net.softsociety.spring7.service;

import net.softsociety.spring7.domain.Board;
import net.softsociety.spring7.domain.Reply;
import net.softsociety.spring7.util.PageNavigator;

import java.util.List;

public interface BoardService {
    // 글 저장
    public int write(Board board);

    // 글 한개 읽기
    public Board read(int boardseq);

    // 글 목록(페이징 없이)
    public List<Board> list(PageNavigator navi, String searchItem, String searchWord);

    // 글 삭제
    public int delete(int boardseq);

    // 글 수정
    public int update(Board board);

    // 전체 글 개수 조회
    public int getBoardCount(String searchItem, String searchWord);

    // 조회 수 증가
    public int updateHitcount(int boardseq);

}
