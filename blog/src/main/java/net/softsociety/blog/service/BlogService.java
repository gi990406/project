package net.softsociety.blog.service;

import net.softsociety.blog.domain.Blog;
import net.softsociety.blog.util.PageNavigator;

import java.util.List;

public interface BlogService {
    // 글 저장
    public int write(Blog blog);

    // 글 한개 읽기
    public Blog read(int blogseq);

    // 글 목록
    public List<Blog> list(PageNavigator navi, String searchItem, String searchWord);

    // 글 삭제
    public int delete(int blogseq);

    // 글 수정
    public int update(Blog blog);

    // 전체 글 개수 조회
    public int getBlogCount(String searchItem, String searchWord);

    // 조회 수 증가
    public int updateLikecnt(int blogseq);

}
