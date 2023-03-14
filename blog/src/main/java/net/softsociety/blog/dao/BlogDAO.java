package net.softsociety.blog.dao;

import net.softsociety.blog.domain.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlogDAO {
    // 글 저장
    public int insertBlog(Blog blog);

    // 글 한개 읽기
    public Blog selectBlog(int blogseq);

    // 글 목록
    public List<Blog> selectBlogList(Map<String, Object> map);


    // 글 삭제
    public int deleteBlog(int blogseq);

    // 글 수정
    public int updateBlog(Blog blog);

    // 글 개수 조회
    public int getBlogCount(Map<String, Object> map);

    // 추천 수 증가
    public int updateLikecnt(int blogseq);
}
