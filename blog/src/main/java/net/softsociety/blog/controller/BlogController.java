package net.softsociety.blog.controller;

import net.softsociety.blog.domain.Blog;
import net.softsociety.blog.service.BlogService;
import net.softsociety.blog.util.PageNavigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {

    @Value("${user.board.page}")
    int countPerPage;

    @Value("${user.board.group}")
    int pagePerGroup;
    @Autowired
    BlogService blogService;

    // 게시글 화면 요청
    @GetMapping("/blog/boardlist")
    public String boardlist(
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "searchItem", defaultValue = "title") String searchItem,
            @RequestParam(value = "searchWord", defaultValue = "") String searchWord,
            Model model) {

        System.out.println("커런트페이지 : "+ currentPage);
        int totalRecordCount = blogService.getBlogCount(searchItem, searchWord);

        PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, currentPage, totalRecordCount);

        // 게시글 목록을 DB로부터 요청하는 문장 필요
        List<Blog> list = blogService.list(navi, searchItem, searchWord);

        model.addAttribute("navi", navi);
        model.addAttribute("searchItem", searchItem);
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("list", list);

        return "/blog/boardlist";
    }
}
