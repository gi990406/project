package net.softsociety.spring7.service;

import net.softsociety.spring7.dao.BoardDAO;
import net.softsociety.spring7.domain.Board;
import net.softsociety.spring7.domain.Reply;
import net.softsociety.spring7.util.PageNavigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    BoardDAO boardDao;

    @Override
    public int write(Board board) {
        int result = boardDao.insertBoard(board);
        return result;
    }

    @Override
    public Board read(int boardseq) {
        Board board = boardDao.selectBoard(boardseq);
        int result = this.updateHitcount(boardseq);

        return board;
    }

    // 게시글 목록 요청
    @Override
    public List<Board> list(PageNavigator navi, String searchItem, String searchWord) {
        Map<String, Object> map = new HashMap<>();

        map.put("srow", navi.getStartRecord());
        map.put("erow", navi.getEndRecord());
        map.put("searchItem", searchItem);
        map.put("searchWord", searchWord);

        System.out.println("srow: " + navi.getStartRecord());
        System.out.println("erow: " + navi.getEndRecord());
        System.out.println("searchItem: " + searchItem);
        System.out.println("searchWord: " + searchWord);

        List<Board> list = boardDao.selectBoardList(map);

        return list;
    }

    @Override
    public int delete(int boardseq) {
        int result = boardDao.deleteBoard(boardseq);

        return result;
    }

    @Override
    public int update(Board board) {
        int result = boardDao.updateBoard(board);

        return result;
    }

    @Override
    public int getBoardCount(String searchItem, String searchWord) {
        Map<String, Object> map = new HashMap<>();

        map.put("searchItem", searchItem);
        map.put("searchWord", searchWord);

        int total = boardDao.getBoardCount(map);
        return total;
    }

    @Override
    public int updateHitcount(int boardseq) {
        int result = boardDao.updateHitcount(boardseq);

        return result;
    }

}
