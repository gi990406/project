package net.softsociety.spring7.controller;

import net.softsociety.spring7.domain.Board;
import net.softsociety.spring7.service.BoardService;
import net.softsociety.spring7.util.FileService;
import net.softsociety.spring7.util.PageNavigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

@Controller
public class BoardController {

    @Value("${user.board.page}")
    int countPerPage;

    @Value("${user.board.group}")
    int pagePerGroup;

    @Value("${spring.servlet.multipart.location}")
    String uploadPath;

    @Autowired
    BoardService boardService;

    // 게시글 화면 요청
    @GetMapping("/board/boardlist")
    public String boardlist(
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "searchItem", defaultValue = "title") String searchItem,
            @RequestParam(value = "searchWord", defaultValue = "") String searchWord,
            Model model) {

        System.out.println("커런트페이지 : "+ currentPage);
        // 전체 글 개수, 원래는 DB에서 가져와야 한다.
        int totalRecordCount = boardService.getBoardCount(searchItem, searchWord);

        PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, currentPage, totalRecordCount);

/**
 *  // 테스트 코드

        int page = 0;
        int countPerPage = 10;

        int srow = 1 +(currentPage - 1) * countPerPage;           // 1
        int erow = countPerPage + (currentPage - 1) * countPerPage;           // 10

        page = totalRecordCount / countPerPage;
        page += (totalRecordCount % countPerPage == 0) ? 0:1;

        System.out.println("총 글 개수: " + totalRecordCount);
        System.out.println("총 페이지 수: " + page);
        System.out.println("현재 요청한 페이지: " + currentPage);
        System.out.println("현재 페이지 시작 글 번호: " + srow);
        System.out.println("현재 페이지 마지막 글 번호" + erow);

        System.out.println("한 그룹당 글 개수: " + countPerPage);

        System.out.println("그룹 당 페이지 수: " + pagePerGroup);
        */

        // 게시글 목록을 DB로부터 요청하는 문장 필요
        List<Board> list = boardService.list(navi, searchItem, searchWord);

        model.addAttribute("navi", navi);
        model.addAttribute("searchItem", searchItem);
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("list", list);

        return "/board/boardlist";
    }

    // 게시글 쓰기 화면 요청
    @GetMapping("/board/write")
    public String boardWrite() {
        return "/board/boardwrite";
    }

    // 게시글 저장 요청
    @PostMapping("/board/boardwrite")
    public String boardWrite(Board board, MultipartFile upload) {
//        System.out.println("파일의 크기: " + upload.getSize());
//        System.out.println("파일의 이름: " + upload.getOriginalFilename());
//        System.out.println("파일 존재 여부: " + upload.isEmpty());

        String originalFilename = null;
        String savedFileName = null;

        if (!upload.isEmpty()) {
            originalFilename = upload.getOriginalFilename();
            savedFileName = FileService.savedFile(upload, uploadPath);
        }

        
        // DB에 저장하기 위해 originalFilename, savedFileName을 Board에 세팅
        board.setOriginalfile(originalFilename);
        board.setSavedfile(savedFileName);

        // DB에 데이터 저장
        int result = boardService.write(board);

        return "redirect:/board/boardlist";
    }

    // 글 1개 조회
    @GetMapping("/board/read")
    public String boardRead(int boardseq, Model model) {
        // DB로 요청
        Board board = boardService.read(boardseq);

        // model에 담는다.
        model.addAttribute("board", board);

        return "/board/boardread";
    }

    /**
     * boardseq에 해당하는 글 삭제 요청
     * @param boardseq
     * @return
     */
    @GetMapping("/board/delete")
    public String boardDelete(int boardseq) {
        
        Board board = boardService.read(boardseq);

        // 삭제하려는 파일이 조회가 되지 않을 경우

        if (board == null) {
            return "redirect:/";
        }

        // 저장된 실제 파일명을 읽어옴.

        // DB에 저장된 게시글을 삭제하고 결과가 1이면 파일도 삭제
        // 저장된 파일이 있을 때만 파일 삭제 실시
        int result = boardService.delete(boardseq);
        String savedfile = board.getSavedfile();

        if (result == 1 && savedfile != null) {
            String fullPath = uploadPath + "/" + savedfile;
            FileService.deleteFile(fullPath);

        }
        return "redirect:/board/boardlist";
    }

    /**
     * 글 수정 화면 요청
     * @param boardseq
     * @param model
     * @return
     */
    @GetMapping("/board/update")
    public String update(int boardseq, Model model) {
        Board board = boardService.read(boardseq);

        model.addAttribute("board", board);

        return "/board/boardupdate";
    }

    /**
     * 글 수정 처리 요청
     * @param board
     * @param upload
     * @return
     */
    @PostMapping("/board/boardupdate")
    public String update(Board board, MultipartFile upload, RedirectAttributes rttr) {
        
        Board oldBoard = null;
        String oldSavedfile = null;
        String savedfile = null;
        
        // 기존에 파일이 첨부되어 있으면 기존 파일을 삭제 후 새 파일을 저장
        if (upload != null && !upload.isEmpty()) {
            oldBoard = boardService.read(board.getBoardseq()); // DB로부터 저장된 파일 가져오기
            oldSavedfile = (oldBoard == null)? null:oldBoard.getSavedfile();

            savedfile = FileService.savedFile(upload, uploadPath);
            board.setSavedfile(savedfile);
            board.setOriginalfile(upload.getOriginalFilename());
        }

        int result = boardService.update(board); // 오리지널 파일, 세이브드 파일
        if (result == 1 && savedfile != null) {
            FileService.deleteFile(uploadPath +"/" + oldSavedfile);
        }
        
        // boardread로 리다이렉트하세요. int boardseq를 가져가야함.
        // RedirectAttri... rttr; board 객체에서 boardseq를 꺼낼 수 있다.
        rttr.addAttribute("boardseq", board.getBoardseq());

        return "redirect:/board/boardlist";
    }

    /**
     * 첨부파일 다운로드
     * @param boardseq
     * @return
     */
    @GetMapping("/board/download")
    public String download(int boardseq, HttpServletResponse response) {
        Board board = boardService.read(boardseq);

        // 원래 파일명
        String originalFileName = board.getOriginalfile();

        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(originalFileName, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 저장된 파일명
        String savedFileName = board.getSavedfile();
        String fullPath = uploadPath + "/" + savedFileName;

        // 스트림 설정(HDD 입력 스트림, 클라이언트에게 전달할 출력 스트림)
        FileInputStream filein = null;
        ServletOutputStream fileout = null;

        try {
            filein = new FileInputStream(fullPath);
            fileout = response.getOutputStream();

            FileCopyUtils.copy(filein, fileout);

            filein.close();
            fileout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}
